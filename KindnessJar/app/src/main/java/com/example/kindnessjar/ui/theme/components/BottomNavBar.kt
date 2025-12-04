package com.example.kindnessjar.ui.theme.components

import androidx.compose.material3.*
import androidx.compose.runtime.*

import com.example.kindnessjar.navigation.Routes

@Composable
fun BottomNavBar(onNavigate: (String) -> Unit) {
    var selectedIndex by remember { mutableStateOf(0) }

    NavigationBar {

        NavigationBarItem(
            selected = selectedIndex == 0,
            onClick = {
                selectedIndex = 0
                onNavigate(Routes.PROGRESS)
            },
            icon = {},
            label = { Text("Progress") }
        )

        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = {
                selectedIndex = 1
                onNavigate(Routes.HOME)
            },
            icon = {},
            label = { Text("Home") }
        )



        NavigationBarItem(
            selected = selectedIndex == 2,
            onClick = {
                selectedIndex = 2
                onNavigate(Routes.HISTORY)
            },
            icon = {},
            label = { Text("History") }
        )
    }
}
