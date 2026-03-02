package com.example.praktam_2417051055

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.praktam_2417051055.ui.HomeScreen
import com.example.praktam_2417051055.ui.theme.PrakTAM_2417051055Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTAM_2417051055Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreenWrapper(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@androidx.compose.runtime.Composable
fun HomeScreenWrapper(modifier: Modifier = Modifier) {
    androidx.compose.foundation.layout.Box(modifier = modifier) {
        HomeScreen()
    }
}
