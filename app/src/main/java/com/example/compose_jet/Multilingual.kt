package com.example.compose_jet

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_jet.ui.theme.Compose_JetTheme

class Multilingual : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_JetTheme {
                lan()


            }
        }
    }
}

@Composable
fun lan(){
    Column(modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Text(text= stringResource(id=R.string.welcome))
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick={}){
            Text(text= stringResource(id=R.string.login))
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(text= stringResource(id=R.string.hellouser, "User"))
        val count =2
        Text(text= pluralStringResource(id=R.plurals.itemcount, count, count))
        Button(onClick={}){
            Text(text= stringResource(id=R.string.Signup))
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Compose_JetTheme {
        lan()

    }
}