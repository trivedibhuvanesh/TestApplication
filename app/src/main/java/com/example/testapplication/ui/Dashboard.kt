package com.example.testapplication.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testapplication.UserViewModel
import com.example.testapplication.navigation.bottom_navigation.BottomNavItems
import com.example.testapplication.ui.screens.HomeScreen
import com.example.testapplication.ui.screens.ProductListingBody
import com.example.testapplication.ui.screens.SearchBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(userViewModel: UserViewModel) {

    val navController = rememberNavController()
    val bottomNavItems = listOf(
        BottomNavItems.Home,
        BottomNavItems.List,
        BottomNavItems.Cart,
        BottomNavItems.Wishlist,
        BottomNavItems.Profile
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFF4F4F4),
        topBar = {
            TopAppBar(
                title = {
                SearchBar()
            }, navigationIcon = {
                IconButton(onClick = {

                }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFF4F4F4),
                    navigationIconContentColor = Color.Black
                )
            )
        },

        bottomBar = {
            NavigationBar(
                containerColor = Color.Black
            ) {
                val currentDestination =
                    navController.currentBackStackEntryAsState().value?.destination

                bottomNavItems.forEach { item ->

                    NavigationBarItem(
                        selected = currentDestination?.route == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null,
                                tint = if (currentDestination?.route == item.route) Color(0xFF800080) else Color.White
                            )
                        },
                        alwaysShowLabel = false,
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .padding(0.dp)
                            .height(56.dp),
                    )
                }
            }

        }) { paddingValues ->


        NavHost(
            navController = navController,
            startDestination = BottomNavItems.Home.route,
            modifier = Modifier.Companion.padding(paddingValues)
        ) {
            composable(BottomNavItems.Home.route) {
                ProductListingBody(
                    userViewModel.products.collectAsState().value?.products
                )
            }
            composable(BottomNavItems.List.route) { HomeScreen("Search") }
            composable(BottomNavItems.Cart.route) { HomeScreen("Cart") }
            composable(BottomNavItems.Wishlist.route) { HomeScreen("Wishlist") }
            composable(BottomNavItems.Profile.route) { HomeScreen("Profile") }
        }
    }
}