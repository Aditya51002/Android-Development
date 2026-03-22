package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
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
                    LanguageGrid(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

data class Language(val name: String, val icon: ImageVector)

@Composable
fun LanguageGrid(modifier: Modifier = Modifier) {
    val languages = listOf(
        Language("Kotlin", Icons.Default.Build),
        Language("Java", Icons.Default.Build),
        Language("Python", Icons.Default.Build),
        Language("C++", Icons.Default.Build),
        Language("C#", Icons.Default.Build),
        Language("JavaScript", Icons.Default.Build),
        Language("TypeScript", Icons.Default.Build),
        Language("Swift", Icons.Default.Build),
        Language("Go", Icons.Default.Build),
        Language("Rust", Icons.Default.Build),
        Language("Ruby", Icons.Default.Build),
        Language("PHP", Icons.Default.Build),
        Language("Dart", Icons.Default.Build),
        Language("HTML", Icons.Default.Build),
        Language("CSS", Icons.Default.Build),
        Language("SQL", Icons.Default.Build),
        Language("R", Icons.Default.Build),
        Language("Shell", Icons.Default.Build),
        Language("Kotlin", Icons.Default.Build),
        Language("Java", Icons.Default.Build)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = modifier.fillMaxSize().padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(languages) { language ->
            LanguageItem(language)
        }
    }
}
@Composable
fun LanguageItem(language: Language) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = language.icon,
                contentDescription = language.name,
                modifier = Modifier.size(60.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = language.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LanguageGridPreview() {
    MyApplicationTheme {
        LanguageGrid()
    }
}
