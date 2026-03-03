package com.example.compose_jet

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_jet.ui.theme.Compose_JetTheme

class ScenerioBAse : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_JetTheme {
                SceanFirst()
            }
        }
    }
}

@Composable
fun SceanFirst(){
    Column(modifier = Modifier.fillMaxSize().padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        val context = LocalContext.current

        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://movie-booking-r3jmj9dfk-aditya51002s-projects.vercel.app/"))
            context.startActivity(intent)
        }) {
            Text(text = "Open Google")
        }

        Spacer(modifier = Modifier.padding(15.dp))

        Button(onClick = {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:9721392563")
            }
            context.startActivity(intent)

        }) {
            Text(text = "Open Dial Phone")
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Button(onClick = {
            val intent=Intent(Intent.ACTION_PICK).apply {
                type="image/*"
            }
            context.startActivity(intent)
        }) {
            Text(text="Gallery")
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Button(onClick = {
            val intent=Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            }
            context.startActivity(intent)
        }) {
            Text(text="Camera")
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Button(onClick = {
            val intent=Intent(Intent.ACTION_GET_CONTENT).apply {
                type="application/pdf"
            }
            context.startActivity(intent)
        }) {
            Text(text="Open Document")
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Button(onClick = {
            val intent=Intent(Intent.ACTION_SENDTO).apply{
                data=Uri.parse("mailto:adityamaurya510@gmial.com")
                putExtra(Intent.EXTRA_SUBJECT,"Test Email")
                putExtra(Intent.EXTRA_TEXT,"This is email")
            }
            context.startActivity(intent)
        }){
            Text(text="Email")
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Button(onClick = {
            val intent=Intent(Intent.ACTION_SEND).apply{
                type="text/plain"
                putExtra(Intent.EXTRA_TEXT,"Sharing text" + "using implicit intent")
            }
            context.startActivity(Intent.createChooser(intent,"Share via"))
        }){
            Text(text="SMS")
        }


    }
}

@Preview(showBackground = true)
@Composable
fun ScenarioBasePreview() {
    Compose_JetTheme {
        SceanFirst()
    }
}
