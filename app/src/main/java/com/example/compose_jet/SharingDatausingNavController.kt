package com.example.compose_jet

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_jet.ui.theme.Compose_JetTheme

class SharingDatausingNavController : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge();
        setContent {
            Compose_JetTheme() {
                AppNavHost()
            }
        }
    }
}
@Composable
fun AppNavHost(){
    val nav=rememberNavController()
    NavHost(
        navController = nav,
        startDestination = "home",
        modifier = Modifier.fillMaxSize()
    ) {
        composable("home") { SendMessage(nav) }

        composable("detail/{textValue}") { backStack ->
            val textValue = backStack.arguments?.getString("textValue") ?: ""
            ReceiveMessage(nav, textValue)
        }
    }
}
@Composable
fun SendMessage(nav: NavController){
    var name by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        OutlinedTextField(value = name, onValueChange = { name = it },
            label = { Text("Enter your name") },
            modifier = Modifier.fillMaxWidth().padding(20.dp))
        Button(onClick ={
            nav.navigate("detail/$name")
        }){
            Text("Send")
        }

        Button(onClick = {
            val intent = Intent(Settings.ACTION_SETTINGS)
            context.startActivity(intent)
        }) {
            Text("Open Settings")
        }

    }
}
@Composable
fun ReceiveMessage(nav:NavController,name:String){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(
            text = "Received: $name"
        )
        Button(onClick = {
            nav.popBackStack()
        })
        {
            Text("Go Back")
        }


    }

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview14() {
    Compose_JetTheme(){
        SendMessage(rememberNavController())
    }
}
