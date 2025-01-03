package com.laksamana.movio.ui.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.laksamana.movio.ui.detail.MovieDetailScreen
import com.laksamana.movio.ui.home.HomeScreen
import com.laksamana.movio.utils.K

@Composable
fun MovieNavigationGraph( //TODO: Function untuk navigasi antarhalaman dengan menggunakan navhost
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost( //TODO: Menetapkan Home screen sebagai tampilan awal aplikasi
        navController = navController,
        startDestination = Route.HomeScreen().route,
        modifier = modifier.fillMaxSize()
    ) {
        composable(
            route = Route.HomeScreen().route,
            enterTransition = { fadeIn() + scaleIn() },
            exitTransition = { fadeOut() + shrinkOut() }
        ) {
            HomeScreen(
                onMovieClick = {
                    navController.navigate(
                        Route.FilmScreen().getRouteWithArgs(id = it)
                    ) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) { inclusive = false }
                    }
                }
            )
        }

        composable( //TODO: Composable navigasi ke halaman detail film
            route = Route.FilmScreen().routeWithArgs,
            arguments = listOf(navArgument(name = K.MOVIE_ID) { type = NavType.IntType })
        ) {
            MovieDetailScreen( //TODO: Memanggil tampilan detail
                onNavigateUp = { //TODO: Navi
                    navController.navigateUp()
                },
                onMovieClick = { //TODO: Untuk saat pengguna app mengeklik rekomendasi film didalam halaman detail, untuk merefresh halaman sehingga data yang ditampilkan berubah
                    navController.navigate(
                        Route.FilmScreen().getRouteWithArgs(id = it)
                    ) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) { inclusive = false }
                    }
                },
                onActorClick = {} //TODO: Untuk navigasi saat mengeklik aktor (belum implementasi apapun
            )
        }
    }

}