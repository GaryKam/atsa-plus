package io.github.garykam.atsaplus.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.garykam.atsaplus.ui.home.HomeScreen
import io.github.garykam.atsaplus.ui.memorydifference.MemoryDifferenceScreen
import io.github.garykam.atsaplus.ui.memorydifference.MemoryDifferenceWelcomeScreen
import io.github.garykam.atsaplus.ui.memoryvariable.MemoryVariableScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Home.route) {
        composable(route = Home.route) {
            HomeScreen(
                onClickMemoryDifference = { navController.navigate(MemoryDifferenceWelcome.route) },
                onClickMemoryVariable = { navController.navigate(MemoryVariable.route) }
            )
        }

        composable(route = MemoryDifferenceWelcome.route) {
            MemoryDifferenceWelcomeScreen(
                onStart = { navController.navigate(MemoryDifference.route) },
                onBack = { navController.popBackStack() }
            )
        }

        composable(route = MemoryDifference.route) {
            MemoryDifferenceScreen()
        }

        composable(route = MemoryVariable.route) {
            MemoryVariableScreen(onBack = { navController.popBackStack() })
        }
    }
}