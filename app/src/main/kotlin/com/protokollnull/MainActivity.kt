package com.protokollnull

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("PROTOKOLL.NULL") }) }
    ) { padding ->
        Text("Hallo Lisa 🚀 – App gestartet!", modifier = Modifier.padding(padding))
    }
}

@Preview
@Composable
fun PreviewApp() {
    App()
}
