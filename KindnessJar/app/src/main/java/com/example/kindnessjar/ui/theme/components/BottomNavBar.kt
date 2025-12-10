package com.example.kindnessjar.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.kindnessjar.navigation.Routes

@Composable
fun BottomNavBar(navController: NavHostController) {

    // Observe current screen
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination: NavDestination? = navBackStackEntry?.destination

    // Define nav items in your requested order
    val navItems = listOf(
        Routes.PROGRESS,   // LEFT
        Routes.HOME,       // CENTER
        Routes.HISTORY     // RIGHT
    )

    NavigationBar {

        navItems.forEach { route ->

            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == route } == true,
                onClick = {
                    if (currentDestination?.route != route) {
                        navController.navigate(route) {
                            launchSingleTop = true
                            popUpTo(Routes.HOME) { inclusive = false }
                        }
                    }
                },
                icon = {},
                label = {
                    Text(
                        when (route) {
                            Routes.PROGRESS -> "Progress"
                            Routes.HOME -> "Home"
                            Routes.HISTORY -> "History"
                            else -> ""
                        }
                    )
                }
            )
        }
    }
}
