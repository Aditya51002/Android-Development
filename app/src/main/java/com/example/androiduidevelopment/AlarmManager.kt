package com.example.androiduidevelopment

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiduidevelopment.ui.theme.AndroidUIDevelopmentTheme

class AlarmManagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidUIDevelopmentTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AlarmScreen(
                        modifier = Modifier.padding(innerPadding),
                        onSetAlarm = { setAlarm(this) }
                    )
                }
            }
        }
    }

    private fun setAlarm(context: Context) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java)

        val pendingIntent = PendingIntent.getBroadcast(context, 0, intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )
        val triggerTime = System.currentTimeMillis() + 5000
        alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent)
        Toast.makeText(context, "Alarm set for 5 seconds from now", Toast.LENGTH_SHORT).show()
    }
}

@Composable
fun AlarmScreen(modifier: Modifier = Modifier, onSetAlarm: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Alarm Manager Demo", modifier = Modifier.padding(16.dp))
        Button(onClick = onSetAlarm) {
            Text("Set Alarm (5 seconds)")
        }
    }
}
