package com.meneses.riakkv

import com.meneses.riakkv.repository.MovieRepository
import com.meneses.riakkv.service.MovieService
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RiakkvApplication

fun main(args: Array<String>) {
    runApplication<RiakkvApplication>(*args)

    println("Started")

    val repository = MovieRepository()
        .apply { connect() }

    MovieService(repository).run {
        println("\nExercise 1")
        populateDataBase()

        println("\nExercise 2")
        getDirectorsAndGenres()

        println("\nExercise 3")
        getAllMovieActors()

        println("\nExercise 4")
        getAllScreenPlayWriters()

        println("\nExercise 5")
        deleteMovie()

        println("\nExercise 6")
        updateMovieRatings()

        println("\nExercise 7")
        getDirectorsWithTotalMoviesCosts()
    }
}