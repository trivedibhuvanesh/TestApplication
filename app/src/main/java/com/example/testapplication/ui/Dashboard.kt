package com.example.testapplication.ui

import androidx.compose.foundation.background
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
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testapplication.UserViewModel
import com.example.testapplication.ui.screens.SearchBar
import com.example.testapplication.ui.screens.ProductListingBody
import com.example.testapplication.ui.theme.HomeScreen
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.colorResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(userViewModel: UserViewModel) {

    val navController = rememberNavController()
    val bottomItems = listOf(
        BottomItem.Home,
        BottomItem.List,
        BottomItem.Cart,
        BottomItem.Wishlist,
        BottomItem.Profile
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

                bottomItems.forEach { item ->

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
            startDestination = BottomItem.Home.route,
            modifier = Modifier.Companion.padding(paddingValues)
        ) {
            composable(BottomItem.Home.route) {
                ProductListingBody(
                    userViewModel.products.collectAsState().value?.products
                )
            }
            composable(BottomItem.List.route) { HomeScreen("Search") }
            composable(BottomItem.Cart.route) { HomeScreen("Cart") }
            composable(BottomItem.Wishlist.route) { HomeScreen("Wishlist") }
            composable(BottomItem.Profile.route) { HomeScreen("Profile") }
        }
    }
}