package com.example.myapplication.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.authGraph(navController: NavController, onAuthSuccess: () -> Unit) {
    composable("login") {
        LoginScreen(
            onAuthSuccess = onAuthSuccess,
            onNavigateToSignUp = { navController.navigate("signup") }
        )
    }
    composable("signup") {
        SignUpScreen(
            onAuthSuccess = onAuthSuccess,
            onNavigateToLogin = { navController.navigate("login") }
        )
    }
}