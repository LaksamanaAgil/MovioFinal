package com.laksamana.movio.movie.data.repository_impl

import com.laksamana.movio.common.data.ApiMapper
import com.laksamana.movio.movie.data.remote.api.MovieApiService
import com.laksamana.movio.movie.data.remote.models.MovieDto
import com.laksamana.movio.movie.domain.models.Movie
import com.laksamana.movio.movie.domain.repository.MovieRepository
import com.laksamana.movio.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl( //TODO: Implementasi dari Repository Film
    private val movieApiService: MovieApiService, //TODO: Memangggil file API
    private val apiMapper: ApiMapper<List<Movie>, MovieDto> //TODO: Memanggil mapper API yang mengirim data dari entity Moviedto ke domain Movie
) : MovieRepository {
    override fun fetchDiscoverMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading())
        val movieDto = movieApiService.fetchDiscoverMovie()
        apiMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        emit(Response.Error(e))
    }

    override fun fetchTrendingMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading())
        val movieDto = movieApiService.fetchTrendingMovie()
        apiMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        emit(Response.Error(e))
    }
}