package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class LazyVerticalGrid : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TeamGrid(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TeamGrid(modifier: Modifier = Modifier) {
    val items = listOf(
        Team("1", "India", R.drawable.india),
        Team("2", "South Africa", R.drawable.southafrica),
        Team("3", "Australia", R.drawable.australia),
        Team("4", "New Zealand", R.drawable.newzealand),
        Team("5", "West Indies", R.drawable.westindies),
        Team("6", "Sri Lanka", R.drawable.srilanka),
        Team("7", "Bangladesh", R.drawable.bangladesh),
        Team("8", "Afghanistan", R.drawable.afghanistan),
        Team("9", "England", R.drawable.england),
        Team("10", "Teams", R.drawable.img)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize().padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { team ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = team.flagRes),
                        contentDescription = team.name,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(bottom = 8.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = team.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamGridPreview() {
    MyApplicationTheme {
        TeamGrid()
    }
}
