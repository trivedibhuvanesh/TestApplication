package com.example.testapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testapplication.ui.theme.TestApplicationTheme
import com.example.testapplication.navigation.main_screen_navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestApplicationTheme {
                Scaffold(
                    modifier = Modifier.Companion.padding(top = 12.dp).fillMaxSize(),
                    containerColor = Color.Companion.White
                ) { innerPadding ->
                    Navigation()
                }
            }
        }
    }
}