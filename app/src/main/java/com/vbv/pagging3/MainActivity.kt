package com.vbv.pagging3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.vbv.pagging3.ui.screen.home.view.HomeScreen
import com.vbv.pagging3.ui.theme.Pagging3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pagging3Theme {
                HomeScreen(Modifier.fillMaxSize())
            }
        }
    }
}
