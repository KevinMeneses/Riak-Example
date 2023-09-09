package com.meneses.riakkv.service

import com.meneses.riakkv.model.Rating
import com.meneses.riakkv.repository.MovieRepository
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import java.lang.NullPointerException

class MovieService(
    private val repository: MovieRepository
) {
    fun populateDataBase() = with(repository) {
        var created = saveValue("Planet of the Apes", "{ \"Title\":\"Planet of the Apes\", \"Year\":\"2001\", \"Released\":\"27 Jul 2001\", \"Runtime\":\"119 min\", \"Genre\":\"Action, Adventure, Sci-Fi\", \"Directors\": [\"Tim Burton\"], \"Writers\":[{\"name\":\"Pierre Boulle\", \"contribution\":\"novel\"}, {\"name\":\"William Broyles Jr.\", \"contribution\":\"screenplay\"}, {\"name\":\"Lawrence Konner\", \"contribution\":\"screenplay\"}, {\"name\":\"Mark Rosenthal\", \"contribution\":\"screenplay\"}], \"Actors\":[\"Mark Wahlberg\", \"Tim Roth\", \"Helena Bonham Carter\", \"Michael Clarke Duncan\"], \"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"5.7/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"45%\"},{\"Source\":\"Metacritic\",\"Value\":\"50/100\"}], \"Cost\":\"\$178,094,583\", \"Production\":\"20th Century Fox\", \"Website\":\"http://www.planetoftheapes.com\"}")
        var fetched = getValue("Planet of the Apes")
        println("Object created: ${created.value == fetched?.value}")

        created = saveValue("The Social Network", "{\"Title\":\"The Social Network\", \"Year\":\"2010\", \"Released\":\"01 Oct 2010\", \"Runtime\":\"120 min\", \"Genre\":\"Biography, Drama\", \"Directors\": [\"David Fincher\"], \"Writers\":[{\"name\":\"Aaron Sorkin\", \"contribution\":\"screenplay\"}, {\"name\":\"Ben Mezrich\", \"contribution\":\"book\"}], \"Actors\":[\"Jesse Eisenberg\", \"Rooney Mara\", \"Bryan Barter\", \"Dustin Fitzsimons\"], \"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.7/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"96%\"},{\"Source\":\"Metacritic\",\"Value\":\"95/100\"}], \"Cost\":\"\$96,400,000\", \"Production\":\"Columbia Pictures\", \"Website\":\"http://www.thesocialnetwork-movie.com/\"}")
        fetched = getValue("The Social Network")
        println("Object created: ${created.value == fetched?.value}")

        created = saveValue("A.I. Artificial Intelligence", "{\"Title\":\"A.I. Artificial Intelligence\", \"Year\":\"2001\", \"Released\":\"29 Jun 2001\", \"Runtime\":\"146 min\", \"Genre\":\"Adventure, Drama, Sci-Fi\", \"Directors\": [\"Steven Spielberg\"], \"Writers\":[ {\"name\":\"Brian Aldiss\", \"contribution\":\"short story: Supertoys Last All Summer Long\"}, {\"name\":\"Ian Watson\", \"contribution\":\"screen story\"}, {\"name\":\"Steven Spielberg\", \"contribution\":\"screenplay\"}], \"Actors\":[\"Haley Joel Osment\", \"Frances O'Connor\", \"Sam Robards\", \"Jake Thomas\"], \"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.1/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"73%\"},{\"Source\":\"Metacritic\",\"Value\":\"65/100\"}], \"Production\":\"Dreamworks\", \"Website\":\"http://www.aimovie.com\"}")
        fetched = getValue("A.I. Artificial Intelligence")
        println("Object created: ${created.value == fetched?.value}")

        created = saveValue("Blade Runner", "{\"Title\":\"Blade Runner\", \"Year\":\"1982\", \"Released\":\"25 Jun 1982\", \"Runtime\":\"117 min\", \"Genre\":\"Sci-Fi, Thriller\", \"Directors\":[\"Ridley Scott\"], \"Writers\":[{\"name\":\"Hampton Fancher\", \"contribution\":\"screenplay\"}, {\"name\":\"David Webb Peoples\", \"contribution\":\"screenplay\"}, {\"name\":\"Philip K. Dick\", \"contribution\":\"novel\"}], \"Actors\":[\"Harrison Ford\", \"Rutger Hauer\", \"Sean Young\", \"Edward James Olmos\"], \"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.2/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"89%\"},{\"Source\":\"Metacritic\",\"Value\":\"89/100\"}], \"Production\":\"Warner Bros. Pictures\"}")
        fetched = getValue("Blade Runner")
        println("Object created: ${created.value == fetched?.value}")

        created = saveValue("2001: A Space Odyssey", "{\"Title\":\"2001: A Space Odyssey\", \"Year\":\"1968\", \"Released\":\"12 May 1968\", \"Runtime\":\"149 min\", \"Genre\":\"Adventure, Sci-Fi\", \"Directors\":[\"Stanley Kubrick\"], \"Writers\":[ {\"name\":\"Stanley Kubrick\", \"contribution\":\"screenplay\"}, {\"name\":\"Arthur C. Clarke\", \"contribution\":\"screenplay\"}], \"Actors\":[\"Keir Dullea\", \"Gary Lockwood\", \"William Sylvester\", \"Daniel Richter\"], \"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.3/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"94%\"},{\"Source\":\"Metacritic\",\"Value\":\"86/100\"}], \"Cost\":\"\$135,620\", \"Production\":\"Warner Bros. Pictures\", \"Website\":\"N/A\"}")
        fetched = getValue("2001: A Space Odyssey")
        println("Object created: ${created.value == fetched?.value}")

        created = saveValue("WALL-E", "{\"Title\":\"WALL-E\", \"Year\":\"2008\", \"Released\":\"27 Jun 2008\", \"Runtime\":\"98 min\", \"Genre\":\"Animation, Adventure, Family\", \"Directors\":[\"Andrew Stanton\"], \"Writers\":[{\"name\":\"Andrew Stanton\", \"contribution\":\"original story by\"}, {\"name\":\"Pete Docter\", \"contribution\":\"original story by\"}, {\"name\":\"Andrew Stanton\", \"contribution\":\"screenplay\"}, {\"name\":\"Jim Reardon\", \"contribution\":\"screenplay\"}], \"Actors\":[\"Ben Burtt\", \"Elissa Knight\", \"Jeff Garlin\", \"Fred Willard\"], \"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.4/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"96%\"},{\"Source\":\"Metacritic\",\"Value\":\"95/100\"}], \"Cost\":\"\$223,749,872\", \"Production\":\"Walt Disney Pictures\",\"Website\":\"http://www.wall-e.com/\"}")
        fetched = getValue("WALL-E")
        println("Object created: ${created.value == fetched?.value}")

        created = saveValue("Ex Machina", "{ \"Title\":\"Ex Machina\", \"Year\":\"2014\", \"Released\":\"24 Apr 2015\", \"Runtime\":\"108 min\", \"Genre\":\"Drama, Mystery, Sci-Fi\", \"Directors\":[\"Alex Garland\"], \"Writers\": [ {\"name\":\"Alex Garland\"} ], \"Actors\": [\"Domhnall Gleeson\", \"Corey Johnson\", \"Oscar Isaac\", \"Alicia Vikander\" ], \"Ratings\":[ {\"Source\":\"Internet Movie Database\", \"Value\":\"7.7/10\"}, {\"Source\":\"Rotten Tomatoes\",\"Value\":\"92%\"}, {\"Source\":\"Metacritic\",\"Value\":\"78/100\"} ], \"Cost\":\"\$19,012,798\", \"Production\":\"A24 Films\", \"Website\":\"http://meet-ava.com\"}")
        fetched = getValue("Ex Machina")
        println("Object created: ${created.value == fetched?.value}")

        println("Data created")
    }

    fun getDirectorsAndGenres() = with(repository) {
        var movie = getJson("Ex Machina")!!
        println("Movie: Ex Machina")
        var director = movie["Directors"]
        println("Director: $director")
        var genre = movie["Genre"]
        println("Genre: $genre")

        movie = getJson("2001: A Space Odyssey")!!
        println("Movie: 2001: A Space Odyssey")
        director = movie["Directors"]
        println("Director: $director")
        genre = movie["Genre"]
        println("Genre: $genre")
    }

    fun getAllMovieActors() = with(repository) {
        getAllKeys().forEach { key ->
            val movie = getJson(key)!!
            val title = movie["Title"]
            println("Title: $title")
            val actors = movie["Actors"]
            println("Actors: $actors")
        }
    }

    fun getAllScreenPlayWriters() = with(repository) {
        getAllKeys().forEach { key ->
            val movie = getJson(key)!!
            val title = movie["Title"]
            println("Title: $title")
            val writers = movie["Writers"]
            writers?.jsonArray?.forEach { writer ->
                val contribution = writer.jsonObject["contribution"]
                if (contribution.toString().contains("screenplay")) {
                    val name = writer.jsonObject["name"]
                    println("Screenplay contributor: $name")
                }
            }
        }
    }

    fun deleteMovie() = with(repository) {
        deleteValue("The Social Network")
        val wasDeleted = try {
            getValue("The Social Network")
            false
        } catch (e: NullPointerException) {
            true
        }

        println("Was deleted: $wasDeleted")
    }

    fun updateMovieRatings() = with(repository) {
        val movie = getMovie("Planet of the Apes")!!
        val ratingsString = "[ {\"Source\":\"Internet Movie Database\",\"Value\":\"7.5/10\"}, {\"Source\":\"Rotten Tomatoes\",\"Value\":\"56%\"}, {\"Source\":\"Metacritic\",\"Value\":\"60/100\"} ]"
        val ratings = Json.decodeFromString<List<Rating>>(ratingsString)
        val movieUpdated = movie.copy(ratings = ratings)
        val movieString = Json.encodeToString(movieUpdated)
        val movieSaved = saveValue("Planet of the Apes", movieString)

        println("Movie updated: ${movieSaved.value.toStringUtf8()}")
    }

    fun getDirectorsWithTotalMoviesCosts() = with(repository) {
        val directorsWithCosts = mutableMapOf<String, Double>()

        getAllKeys().forEach { key ->
            val movie = getMovie(key)
            val cost = movie?.cost
                ?.replace("$", "")
                ?.replace(",", "")
                ?.toDouble() ?: 0.0

            movie?.directors?.forEach { director ->
                val totalCost = directorsWithCosts[director]
                if (totalCost == null) {
                    directorsWithCosts[director] = cost
                } else {
                    directorsWithCosts[director] = totalCost + cost
                }
            }
        }

        println("Directors and all movies produced total cost: $directorsWithCosts")
    }
}