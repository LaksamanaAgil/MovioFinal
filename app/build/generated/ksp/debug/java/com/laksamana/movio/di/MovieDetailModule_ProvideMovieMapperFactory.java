package com.laksamana.movio.di;

import com.laksamana.movio.common.data.ApiMapper;
import com.laksamana.movio.movie_detail.data.remote.models.MovieDetailDto;
import com.laksamana.movio.movie_detail.domain.models.MovieDetail;
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
public final class MovieDetailModule_ProvideMovieMapperFactory implements Factory<ApiMapper<MovieDetail, MovieDetailDto>> {
  @Override
  public ApiMapper<MovieDetail, MovieDetailDto> get() {
    return provideMovieMapper();
  }

  public static MovieDetailModule_ProvideMovieMapperFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ApiMapper<MovieDetail, MovieDetailDto> provideMovieMapper() {
    return Preconditions.checkNotNullFromProvides(MovieDetailModule.INSTANCE.provideMovieMapper());
  }

  private static final class InstanceHolder {
    private static final MovieDetailModule_ProvideMovieMapperFactory INSTANCE = new MovieDetailModule_ProvideMovieMapperFactory();
  }
}
