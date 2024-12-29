package com.laksamana.movio.di;

import com.laksamana.movio.common.data.ApiMapper;
import com.laksamana.movio.movie.data.remote.models.MovieDto;
import com.laksamana.movio.movie.domain.models.Movie;
import com.laksamana.movio.movie_detail.data.remote.api.MovieDetailApiService;
import com.laksamana.movio.movie_detail.data.remote.models.MovieDetailDto;
import com.laksamana.movio.movie_detail.domain.models.MovieDetail;
import com.laksamana.movio.movie_detail.domain.repository.MovieDetailRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class MovieDetailModule_ProvideMovieDetailRepositoryFactory implements Factory<MovieDetailRepository> {
  private final Provider<MovieDetailApiService> movieDetailApiServiceProvider;

  private final Provider<ApiMapper<MovieDetail, MovieDetailDto>> mapperProvider;

  private final Provider<ApiMapper<List<Movie>, MovieDto>> movieMapperProvider;

  public MovieDetailModule_ProvideMovieDetailRepositoryFactory(
      Provider<MovieDetailApiService> movieDetailApiServiceProvider,
      Provider<ApiMapper<MovieDetail, MovieDetailDto>> mapperProvider,
      Provider<ApiMapper<List<Movie>, MovieDto>> movieMapperProvider) {
    this.movieDetailApiServiceProvider = movieDetailApiServiceProvider;
    this.mapperProvider = mapperProvider;
    this.movieMapperProvider = movieMapperProvider;
  }

  @Override
  public MovieDetailRepository get() {
    return provideMovieDetailRepository(movieDetailApiServiceProvider.get(), mapperProvider.get(), movieMapperProvider.get());
  }

  public static MovieDetailModule_ProvideMovieDetailRepositoryFactory create(
      Provider<MovieDetailApiService> movieDetailApiServiceProvider,
      Provider<ApiMapper<MovieDetail, MovieDetailDto>> mapperProvider,
      Provider<ApiMapper<List<Movie>, MovieDto>> movieMapperProvider) {
    return new MovieDetailModule_ProvideMovieDetailRepositoryFactory(movieDetailApiServiceProvider, mapperProvider, movieMapperProvider);
  }

  public static MovieDetailRepository provideMovieDetailRepository(
      MovieDetailApiService movieDetailApiService, ApiMapper<MovieDetail, MovieDetailDto> mapper,
      ApiMapper<List<Movie>, MovieDto> movieMapper) {
    return Preconditions.checkNotNullFromProvides(MovieDetailModule.INSTANCE.provideMovieDetailRepository(movieDetailApiService, mapper, movieMapper));
  }
}
