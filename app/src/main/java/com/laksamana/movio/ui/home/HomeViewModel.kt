package com.laksamana.movio.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laksamana.movio.movie.domain.models.Movie
import com.laksamana.movio.movie.domain.repository.MovieRepository
import com.laksamana.movio.utils.collectAndHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( //TODO: Viewmodel untuk halaman utama
    private val repository: MovieRepository,
) : ViewModel() { //TODO: Pengambilan data dari Repository
    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow() //TODO: Menetapkan state halaman utama

    init {
        fetchDiscoverMovie()
    }
    init {
        fetchTrendingMovie()
    }


    private fun fetchDiscoverMovie() = viewModelScope.launch {
        repository.fetchDiscoverMovie().collectAndHandle(
            onError = { error ->
                _homeState.update {
                    it.copy(isLoading = false, error = error?.message)
                }
            },
            onLoading = {
                _homeState.update {
                    it.copy(isLoading = true, error = null)
                }
            }
        ) { movie ->
            _homeState.update {
                it.copy(isLoading = false, error = null, discoverMovies = movie)
            }
        }
    }
    private fun fetchTrendingMovie() = viewModelScope.launch {
        repository.fetchTrendingMovie().collectAndHandle(
            onError = { error ->
                _homeState.update {
                    it.copy(isLoading = false, error = error?.message)
                }
            },
            onLoading = {
                _homeState.update {
                    it.copy(isLoading = true, error = null)
                }
            }
        ) { movie ->
            _homeState.update {
                it.copy(isLoading = false, error = null, trendingMovies = movie)
            }
        }
    }


}

data class HomeState(
    val discoverMovies: List<Movie> = emptyList(),
    val trendingMovies: List<Movie> = emptyList(),
    val error: String? = null,
    val isLoading: Boolean = false
)