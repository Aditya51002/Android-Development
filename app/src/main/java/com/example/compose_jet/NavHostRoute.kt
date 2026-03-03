package com.example.compose_jet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcompose.profileClick

@Composable
fun NavHostRoute(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "login") {
        composable("login") {
            Logpage(onLoginClick = {
                navHostController.navigate("DashBoard")
            })
        }
        composable("DashBoard") {
            DashBoard(onDashBoardClick = {
                navHostController.navigate("profileClick")
            })
        }
        composable("profileClick") {
            profileClick(onProfileClick = {
                navHostController.popBackStack()
            })
        }
    }
}

@Composable
fun Logpage(onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login Page", fontSize = 25.sp)
        Button(onClick = onLoginClick) {
            Text(text = "Login")
        }
    }
}

@Composable
fun DashBoard(onDashBoardClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Dashboard", fontSize = 25.sp)
        Button(onClick = onDashBoardClick) {
            Text(text = "Go to Profile")
        }
    }
}
