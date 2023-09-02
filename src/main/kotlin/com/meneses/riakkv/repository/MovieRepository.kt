package com.meneses.riakkv.repository

import com.basho.riak.client.api.RiakClient
import com.basho.riak.client.api.commands.kv.DeleteValue
import com.basho.riak.client.api.commands.kv.FetchValue
import com.basho.riak.client.api.commands.kv.ListKeys
import com.basho.riak.client.api.commands.kv.StoreValue
import com.basho.riak.client.core.RiakCluster
import com.basho.riak.client.core.RiakNode
import com.basho.riak.client.core.query.Location
import com.basho.riak.client.core.query.Namespace
import com.basho.riak.client.core.query.RiakObject
import com.basho.riak.client.core.util.BinaryValue
import com.meneses.riakkv.model.Movie
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject


class MovieRepository(
    private var client: RiakClient? = null,
    private val moviesBucket: Namespace = Namespace("movies")
) {
    fun connect() {
        println("Connecting...")

        val node = RiakNode.Builder()
            .withRemoteAddress("127.0.0.1")
            .withRemotePort(8087)
            .build()

        val cluster = RiakCluster.Builder(node)
            .build()

        cluster.start()
        client = RiakClient(cluster)

        println("Connected")
    }

    fun saveValue(key: String, value: String): RiakObject {
        val movieObject = RiakObject()
            .setContentType("text/plain")
            .setValue(BinaryValue.create(value))
        val movieObjectLocation = Location(moviesBucket, key)

        val storeOp = StoreValue.Builder(movieObject)
            .withLocation(movieObjectLocation)
            .build()

        client!!.execute(storeOp)

        println("object: $key")
        println("value: $value")

        return movieObject
    }

    fun getJson(key: String): JsonObject? {
        val value = getValue(key)?.value?.toStringUtf8() ?: return null
        return Json.parseToJsonElement(value).jsonObject
    }

    fun getMovie(key: String): Movie? {
        val value = getValue(key)?.value?.toStringUtf8() ?: return null
        return Json.decodeFromString(value)
    }

    fun getValue(key: String): RiakObject? {
        val location = Location(moviesBucket, key)
        val fetchOp = FetchValue.Builder(location).build()
        return client!!.execute(fetchOp).getValue(RiakObject::class.java)
    }

    fun getAllKeys(): List<String> {
        val listKeysOp = ListKeys.Builder(moviesBucket).build()
        val listKeysResponse = client!!.execute(listKeysOp)
        return listKeysResponse.map { it.keyAsString }
    }

    fun deleteValue(key: String) {
        val location = Location(moviesBucket, key)
        val deleteOp = DeleteValue.Builder(location).build()
        client!!.execute(deleteOp)
    }
}