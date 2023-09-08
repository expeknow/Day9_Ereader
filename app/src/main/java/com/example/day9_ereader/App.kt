package com.example.day9_ereader

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.day9_ereader.ui.windows.MainWindow
import com.example.day9_ereader.ui.windows.ReadWindow

@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainWindow(navController)
        }
        composable("article") {
            ReadWindow(navController)
        }
    }
}