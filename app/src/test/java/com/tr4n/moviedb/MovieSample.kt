package com.tr4n.moviedb

import com.tr4n.moviedb.data.remote.response.BaseListResponse
import com.tr4n.moviedb.data.remote.response.MovieResponse

object MovieSample {
    val fakeJson = """
{
    "page": 1,
    "results": [
        {
            "adult": false,
            "backdrop_path": "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
            "genre_ids": [
                18,
                80
            ],
            "id": 238,
            "original_language": "en",
            "original_title": "The Godfather",
            "overview": "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
            "popularity": 107.656,
            "poster_path": "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
            "release_date": "1972-03-14",
            "title": "The Godfather",
            "video": false,
            "vote_average": 8.7,
            "vote_count": 17208
        }
    ],
    "total_pages": 533,
    "total_results": 10653
}
   """.trimIndent()

    val mockListMovieResponse = BaseListResponse(
        page = 1,
        totalPages = 1,
        totalResults = 14,
        results = listOf(
            MovieResponse(
                adult = false,
                backdropPath = "/tmU7GeKVybMWFButWEGl2M4GeiP.jpg",
                id = "238",
                originalLanguage = "en",
                originalTitle = "The Godfather",
                overview = "Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.",
                popularity = 107.656,
                posterPath = "/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
                releaseDate = "1972-03-14",
                title = "The Godfather",
                video = false,
                voteAverage = 8.7,
                voteCount = 17208,
            )
        ),
    )
}