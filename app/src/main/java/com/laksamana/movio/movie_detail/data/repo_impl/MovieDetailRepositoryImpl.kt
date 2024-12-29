package com.laksamana.movio.movie_detail.data.repo_impl

import com.laksamana.movio.common.data.ApiMapper
import com.laksamana.movio.movie.data.remote.models.MovieDto
import com.laksamana.movio.movie.domain.models.Movie
import com.laksamana.movio.movie_detail.data.remote.api.MovieDetailApiService
import com.laksamana.movio.movie_detail.data.remote.models.MovieDetailDto
import com.laksamana.movio.movie_detail.domain.models.MovieDetail
import com.laksamana.movio.movie_detail.domain.repository.MovieDetailRepository
import com.laksamana.movio.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieDetailRepositoryImpl(
    private val movieDetailApiService: MovieDetailApiService,
    private val apiDetailMapper: ApiMapper<MovieDetail, MovieDetailDto>,
    private val apiMovieMapper: ApiMapper<List<Movie>, MovieDto>,
) : MovieDetailRepository {
    override fun fetchMovieDetail(movieId: Int): Flow<Response<MovieDetail>> = flow {
        emit(Response.Loading())
        val movieDetailDto = movieDetailApiService.fetchMovieDetail(movieId)
        apiDetailMapper.mapToDomain(movieDetailDto).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        e.printStackTrace()
        emit(Response.Error(e))
    }

    override fun fetchMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading())
        val movieDto = movieDetailApiService.fetchMovie()
        apiMovieMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        e.printStackTrace()
        emit(Response.Error(e))
    }

}