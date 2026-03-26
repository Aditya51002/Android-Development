package com.example.rating

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmojiRating()
        }
    }
}

@Composable
fun EmojiRating() {
    val context = LocalContext.current
    var rating by remember { mutableStateOf("") }

    val emojis = listOf("😡","😕","😐","😊","😍")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Rate Us", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            emojis.forEach {
                Text(
                    text = it,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            rating = it
                            Toast.makeText(context, "Selected $it", Toast.LENGTH_SHORT).show()
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text("Rating: $rating")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUI() {
    EmojiRating()
}