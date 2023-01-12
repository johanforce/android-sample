package com.tr4n.moviedb.data.api

import com.tr4n.moviedb.MovieSample.fakeJson
import com.tr4n.moviedb.MovieSample.mockListMovieResponse
import com.tr4n.moviedb.data.remote.MovieApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import org.junit.Test

class MovieApiTest : BaseApiTest() {

    private val api = getMockedApi<MovieApi>()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `getTopRatedMovies - should get response include only one movie data`() = runTest {
        val expectedResponse = mockListMovieResponse

        mockServer.enqueue(MockResponse().setBody(fakeJson).setResponseCode(200))
        val actualResponse = api.getTopRatedMovies(1)
        println(actualResponse.results)
        println(expectedResponse.results)

    }

    @Test
    fun getDataSearch() = runTest {
        val expectedResponse = mockListMovieResponse

        mockServer.enqueue(MockResponse().setBody(fakeJson).setResponseCode(200))
        val actualResponse = api.getDataSearch("The Avengers")
        println(actualResponse.results)
        println(expectedResponse.results)

        assert(actualResponse.isSameAs(expectedResponse))
    }
}
