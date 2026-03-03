package com.example.compose_jet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_jet.ui.theme.Compose_JetTheme

class SlideBar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_JetTheme {
                slider()
            }
        }
    }
}

@Composable
fun slider(){
    var sliderVal by remember { mutableStateOf(1.0f) }


    Column(modifier = Modifier.fillMaxSize().background(if(sliderVal<=0.5f) Color.Black else Color.Red), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        val context= LocalContext.current
        Image(painter = painterResource( R.drawable.image3), contentDescription = "Selected image", modifier = Modifier.padding(16.dp))


        Spacer(modifier= Modifier.padding(10.dp))


        Text("Ben 10 Theme Song")


        Spacer(modifier= Modifier.padding(10.dp))


        Slider(value = sliderVal, onValueChange = {sliderVal=it
            if(sliderVal<=0.5f){
                Toast.makeText(context, "You are in Dark Mode", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(context, "You are in Light Mode", Toast.LENGTH_SHORT).show()
            }



        })
        Spacer(modifier= Modifier.padding(10.dp))
        Button(onClick={


        }){
            Text("Submit")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Compose_JetTheme {
        slider()
    }
}