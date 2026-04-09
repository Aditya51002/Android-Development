package com.example.androiduidevelopment

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.example.androiduidevelopment.ui.theme.AndroidUIDevelopmentTheme

class ActivtiyPageMove : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidUIDevelopmentTheme {
                NavigationApp()
            }
        }
    }
}

@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen {
                navController.navigate("page2")
            }
        }

        composable("page2") {
            Page2Screen {
                navController.navigate("page3")
            }
        }

        composable("page3") {
            Page3Screen {
                navController.navigate("page4")
            }
        }

        composable("page4") {
            Page4Screen {
                navController.navigate("home") {
                    popUpTo("home") { inclusive = true }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(onClick: () -> Unit) {
    val context = LocalContext.current
    ScreenUI("Home Page", "Go to Page 2") {
        Toast.makeText(context, "Going to Page 2", Toast.LENGTH_SHORT).show()
        onClick()
    }
}

@Composable
fun Page2Screen(onClick: () -> Unit) {
    val context = LocalContext.current
    ScreenUI("Page 2", "Go to Page 3") {
        Toast.makeText(context, "Going to Page 3", Toast.LENGTH_SHORT).show()
        onClick()
    }
}

@Composable
fun Page3Screen(onClick: () -> Unit) {
    val context = LocalContext.current
    ScreenUI("Page 3", "Go to Page 4") {
        Toast.makeText(context, "Going to Page 4", Toast.LENGTH_SHORT).show()
        onClick()
    }
}

@Composable
fun Page4Screen(onClick: () -> Unit) {
    val context = LocalContext.current
    ScreenUI("Page 4", "Back to Home") {
        Toast.makeText(context, "Returning to Home", Toast.LENGTH_SHORT).show()
        onClick()
    }
}

@Composable
fun ScreenUI(title: String, buttonText: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = title, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = onClick) {
                Text(buttonText)
            }
        }
    }
}