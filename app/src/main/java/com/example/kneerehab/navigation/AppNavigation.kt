
package com.example.kneerehab.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.kneerehab.data.injuries
import com.example.kneerehab.data.exercises
import com.example.kneerehab.data.UserPreferences
import com.example.kneerehab.data.database.AppDatabase

import com.example.kneerehab.screens.HomeScreen
import com.example.kneerehab.screens.InjuriesScreen
import com.example.kneerehab.screens.InjuryDetailScreen
import com.example.kneerehab.screens.ExercisesScreen
import com.example.kneerehab.screens.FavoritesScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val context = LocalContext.current

    // Banco de dados SQLite
    val database = remember {
        AppDatabase.getDatabase(context)
    }

    val favoriteDao = remember {
        database.favoriteDao()
    }

    // Preferências do usuário com DataStore
    val userPreferences = remember {
        UserPreferences(context)
    }

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        // Tela inicial
        composable("home") {
            HomeScreen(
                onExploreClick = {
                    navController.navigate("injuries")
                },
                onFavoritesClick = {
                    navController.navigate("favorites")
                },
                userPreferences = userPreferences
            )
        }

        // Favoritos
        composable("favorites") {
            FavoritesScreen(
                favoriteDao = favoriteDao,
                onFavoriteClick = { id ->
                    navController.navigate("injury/$id")
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // Lista de lesões
        composable("injuries") {
            InjuriesScreen(
                onInjuryClick = { id ->
                    navController.navigate("injury/$id")
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        // Detalhes da lesão
        composable(
            route = "injury/{injuryId}",
            arguments = listOf(
                navArgument("injuryId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("injuryId")
            val injury = injuries.find { it.id == id }

            if (injury != null) {
                InjuryDetailScreen(
                    injury = injury,
                    favoriteDao = favoriteDao,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onExercisesClick = {
                        navController.navigate("exercises/${injury.id}")
                    }
                )
            }
        }

        // Exercícios relacionados à lesão
        composable(
            route = "exercises/{injuryId}",
            arguments = listOf(
                navArgument("injuryId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val id = backStackEntry.arguments?.getInt("injuryId")

            val injury = injuries.find { it.id == id }

            val injuryExercises = exercises.filter {
                it.injuryId == id
            }

            if (injury != null) {
                ExercisesScreen(
                    injuryName = injury.name,
                    exercises = injuryExercises,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
