package com.laksamana.movio.di;

import com.laksamana.movio.movie_detail.data.remote.api.MovieDetailApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class MovieDetailModule_ProvideMovieDetailApiServiceFactory implements Factory<MovieDetailApiService> {
  @Override
  public MovieDetailApiService get() {
    return provideMovieDetailApiService();
  }

  public static MovieDetailModule_ProvideMovieDetailApiServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MovieDetailApiService provideMovieDetailApiService() {
    return Preconditions.checkNotNullFromProvides(MovieDetailModule.INSTANCE.provideMovieDetailApiService());
  }

  private static final class InstanceHolder {
    private static final MovieDetailModule_ProvideMovieDetailApiServiceFactory INSTANCE = new MovieDetailModule_ProvideMovieDetailApiServiceFactory();
  }
}
