package com.example.testapplication.navigation.main_screen_navigation

sealed class MainScreen(val route: String) {
    object Login : MainScreen("login_screen")
    object Dashboard : MainScreen("dashboard_screen")
}