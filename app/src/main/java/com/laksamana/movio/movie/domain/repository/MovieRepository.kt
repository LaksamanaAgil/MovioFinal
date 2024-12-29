package com.laksamana.movio.movie.domain.repository

import com.laksamana.movio.movie.domain.models.Movie
import com.laksamana.movio.utils.Response
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun fetchDiscoverMovie(): Flow<Response<List<Movie>>>
    fun fetchTrendingMovie(): Flow<Response<List<Movie>>>
}