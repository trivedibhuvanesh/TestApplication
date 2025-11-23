package com.example.testapplication.ui

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testapplication.UserViewModel
import com.example.testapplication.login.Greeting

sealed class Screen(val route: String) {
    object login : Screen("login_screen")
    object dashboard : Screen("dashboard_screen")
}

@Composable
fun Navigation(
    userViewModel: UserViewModel = hiltViewModel()
) {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = Screen.login.route) {
        composable(Screen.login.route) {
            Greeting(
                {
                    nav.navigate(Screen.dashboard.route) {
                        popUpTo(Screen.login.route) {
                            inclusive = true
                        }
                    }

                    userViewModel.getProducts()
                }
            )
        }

        composable(Screen.dashboard.route) {
            Dashboard(
                userViewModel
            )
        }
    }
}