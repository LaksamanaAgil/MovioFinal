package com.laksamana.movio.di;

import com.laksamana.movio.movie.data.remote.api.MovieApiService;
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
public final class MovieModule_ProvideMovieApiServiceFactory implements Factory<MovieApiService> {
  @Override
  public MovieApiService get() {
    return provideMovieApiService();
  }

  public static MovieModule_ProvideMovieApiServiceFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MovieApiService provideMovieApiService() {
    return Preconditions.checkNotNullFromProvides(MovieModule.INSTANCE.provideMovieApiService());
  }

  private static final class InstanceHolder {
    private static final MovieModule_ProvideMovieApiServiceFactory INSTANCE = new MovieModule_ProvideMovieApiServiceFactory();
  }
}
