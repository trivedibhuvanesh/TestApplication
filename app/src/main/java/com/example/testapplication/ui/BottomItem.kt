package com.example.testapplication.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FormatListBulleted
import androidx.compose.material.icons.outlined.GridOn
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomItem(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomItem("home", "Home", Icons.Outlined.GridOn)
    object List : BottomItem("list", "list", Icons.Outlined.FormatListBulleted)
    object Cart : BottomItem("cart", "Cart", Icons.Outlined.ShoppingBag)
    object Wishlist : BottomItem("wishlist", "Wishlist", Icons.Outlined.Favorite)
    object Profile : BottomItem("profile", "Profile", Icons.Outlined.Person)
}