package com.laksamana.movio.movie_detail.data.remote.api


import com.laksamana.movio.movie.data.remote.models.MovieDto
import com.laksamana.movio.movie_detail.data.remote.models.MovieDetailDto
import com.laksamana.movio.utils.K
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val MOVIE_ID = "movie_id"

interface MovieDetailApiService {
    //TODO: Interface API untuk halaman detail film
    @GET("${K.MOVIE_DETAIL_ENDPOINT}/{$MOVIE_ID}")
    suspend fun fetchMovieDetail(
        @Path(MOVIE_ID) movieId:Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("append_to_response") appendToResponse: String = "credits,reviews"
    ):MovieDetailDto

    @GET(K.MOVIE_ENDPOINT)
    suspend fun fetchMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto
    companion object {
        const val API_KEY = "f0362ecb1bbb9fcaf4dc1439d1d6e6a7"
    }

}