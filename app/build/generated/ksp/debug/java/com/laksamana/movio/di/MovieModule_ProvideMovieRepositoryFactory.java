package com.laksamana.movio.di;

import com.laksamana.movio.common.data.ApiMapper;
import com.laksamana.movio.movie.data.remote.api.MovieApiService;
import com.laksamana.movio.movie.data.remote.models.MovieDto;
import com.laksamana.movio.movie.domain.models.Movie;
import com.laksamana.movio.movie.domain.repository.MovieRepository;
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
public final class MovieModule_ProvideMovieRepositoryFactory implements Factory<MovieRepository> {
  private final Provider<MovieApiService> movieApiServiceProvider;

  private final Provider<ApiMapper<List<Movie>, MovieDto>> mapperProvider;

  public MovieModule_ProvideMovieRepositoryFactory(
      Provider<MovieApiService> movieApiServiceProvider,
      Provider<ApiMapper<List<Movie>, MovieDto>> mapperProvider) {
    this.movieApiServiceProvider = movieApiServiceProvider;
    this.mapperProvider = mapperProvider;
  }

  @Override
  public MovieRepository get() {
    return provideMovieRepository(movieApiServiceProvider.get(), mapperProvider.get());
  }

  public static MovieModule_ProvideMovieRepositoryFactory create(
      Provider<MovieApiService> movieApiServiceProvider,
      Provider<ApiMapper<List<Movie>, MovieDto>> mapperProvider) {
    return new MovieModule_ProvideMovieRepositoryFactory(movieApiServiceProvider, mapperProvider);
  }

  public static MovieRepository provideMovieRepository(MovieApiService movieApiService,
      ApiMapper<List<Movie>, MovieDto> mapper) {
    return Preconditions.checkNotNullFromProvides(MovieModule.INSTANCE.provideMovieRepository(movieApiService, mapper));
  }
}
