package com.laksamana.movio.di;

import com.laksamana.movio.common.data.ApiMapper;
import com.laksamana.movio.movie.data.remote.models.MovieDto;
import com.laksamana.movio.movie.domain.models.Movie;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
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
public final class MovieModule_ProvideMovieMapperFactory implements Factory<ApiMapper<List<Movie>, MovieDto>> {
  @Override
  public ApiMapper<List<Movie>, MovieDto> get() {
    return provideMovieMapper();
  }

  public static MovieModule_ProvideMovieMapperFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ApiMapper<List<Movie>, MovieDto> provideMovieMapper() {
    return Preconditions.checkNotNullFromProvides(MovieModule.INSTANCE.provideMovieMapper());
  }

  private static final class InstanceHolder {
    private static final MovieModule_ProvideMovieMapperFactory INSTANCE = new MovieModule_ProvideMovieMapperFactory();
  }
}
