package com.meneses.riakkv.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    @SerialName("Title")
    val title: String,
    @SerialName("Year")
    val year: String,
    @SerialName("Released")
    val released: String,
    @SerialName("Runtime")
    val runtime: String,
    @SerialName("Genre")
    val genre: String,
    @SerialName("Directors")
    val directors: List<String>,
    @SerialName("Writers")
    val writers: List<Writer>,
    @SerialName("Actors")
    val actors: List<String>,
    @SerialName("Ratings")
    val ratings: List<Rating>,
    @SerialName("Cost")
    val cost: String? = null,
    @SerialName("Production")
    val production: String,
    @SerialName("Website")
    val webSite: String? = null
)

@Serializable
data class Rating (
    @SerialName("Source")
    val source: String,
    @SerialName("Value")
    val value: String
)

@Serializable
data class Writer (
    val name: String? = null,
    val contribution: String? = null
)
