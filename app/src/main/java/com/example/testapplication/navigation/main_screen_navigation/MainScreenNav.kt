package com.example.testapplication.navigation.main_screen_navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testapplication.UserViewModel
import com.example.testapplication.ui.Dashboard
import com.example.testapplication.ui.LoginPage

@Composable
fun Navigation(
    userViewModel: UserViewModel = hiltViewModel()
) {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = MainScreen.Login.route) {
        composable(MainScreen.Login.route) {
            LoginPage(
                {
                    nav.navigate(MainScreen.Dashboard.route) {
                        popUpTo(MainScreen.Login.route) {
                            inclusive = true
                        }
                    }

                    userViewModel.getProducts()
                }
            )
        }

        composable(MainScreen.Dashboard.route) {
            Dashboard(
                userViewModel
            )
        }
    }
}