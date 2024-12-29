package com.laksamana.movio.di

import com.laksamana.movio.common.data.ApiMapper
import com.laksamana.movio.movie.data.remote.models.MovieDto
import com.laksamana.movio.movie.domain.models.Movie
import com.laksamana.movio.movie_detail.data.mapper_impl.MovieDetailMapperImpl
import com.laksamana.movio.movie_detail.data.remote.api.MovieDetailApiService
import com.laksamana.movio.movie_detail.data.remote.models.MovieDetailDto
import com.laksamana.movio.movie_detail.data.repo_impl.MovieDetailRepositoryImpl
import com.laksamana.movio.movie_detail.domain.models.MovieDetail
import com.laksamana.movio.movie_detail.domain.repository.MovieDetailRepository
import com.laksamana.movio.utils.K
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MovieDetailModule {
    private val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }


    @Provides
    @Singleton
    fun provideMovieDetailRepository(
        movieDetailApiService: MovieDetailApiService,
        mapper: ApiMapper<MovieDetail, MovieDetailDto>,
        movieMapper: ApiMapper<List<Movie>, MovieDto>
    ): MovieDetailRepository = MovieDetailRepositoryImpl(
        movieDetailApiService = movieDetailApiService,
        apiDetailMapper = mapper,
        apiMovieMapper = movieMapper,
    )

    @Provides
    @Singleton
    fun provideMovieMapper(): ApiMapper<MovieDetail, MovieDetailDto> = MovieDetailMapperImpl()

    @Provides
    @Singleton
    fun provideMovieDetailApiService(): MovieDetailApiService {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(K.BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(MovieDetailApiService::class.java)
    }




}

