package com.laksamana.movio.movie_detail.domain.repository

import com.laksamana.movio.movie.domain.models.Movie
import com.laksamana.movio.movie_detail.domain.models.MovieDetail
import com.laksamana.movio.utils.Response
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository { //TODO: Mengambil data dari dataclass MovieDetail untuk detail film dan Movie untuk list film
    fun fetchMovieDetail(movieId: Int): Flow<Response<MovieDetail>>
    fun fetchMovie(): Flow<Response<List<Movie>>>
}