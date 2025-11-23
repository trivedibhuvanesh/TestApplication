package com.example.testapplication.navigation.bottom_navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FormatListBulleted
import androidx.compose.material.icons.outlined.GridOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItems(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavItems("home", "Home", Icons.Outlined.GridOn)
    object List : BottomNavItems("list", "list", Icons.Outlined.FormatListBulleted)
    object Cart : BottomNavItems("cart", "Cart", Icons.Outlined.ShoppingBag)
    object Wishlist : BottomNavItems("wishlist", "Wishlist", Icons.Outlined.Favorite)
    object Profile : BottomNavItems("profile", "Profile", Icons.Outlined.Person)
}