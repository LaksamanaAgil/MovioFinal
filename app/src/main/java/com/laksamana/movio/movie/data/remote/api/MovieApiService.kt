package com.laksamana.movio.movie.data.remote.api


import com.laksamana.movio.movie.data.remote.models.MovieDto
import com.laksamana.movio.utils.K
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    //TODO: Interface API untuk mengambil data berupa jumlah hasil film yang ditemukan dan jumlah halaman, yang ditransfer melalui objek DTO
    @GET(K.MOVIE_ENDPOINT)
    suspend fun fetchDiscoverMovie(
        @Query("api_key") apiKey: String = API_KEY, //TODO: Bagian key untuk membantu memperoleh izin pengambilan data dari API
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto

    @GET(K.TRENDING_MOVIE_ENDPOINT)
    suspend fun fetchTrendingMovie(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto
    companion object {  //TODO: Memasukkan API Key untuk moviedb
        const val API_KEY = "f0362ecb1bbb9fcaf4dc1439d1d6e6a7"
    }
}