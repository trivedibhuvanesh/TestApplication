package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent(onClick:(text: String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text("Menu Item 1", Modifier.padding(10.dp).clickable(
            onClick = {
                onClick.invoke("Menu Item 1")
            }
        ), )
        Text("Menu Item 2", Modifier.padding(10.dp).clickable(
            onClick = {
                onClick.invoke("Menu Item 2")
            }
        ))
        Text("Menu Item 3", Modifier.padding(10.dp).clickable(
            onClick = {
                onClick.invoke("Menu Item 3")
            }
        ))
    }
}
