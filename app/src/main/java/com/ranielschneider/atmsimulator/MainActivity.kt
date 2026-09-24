package com.ranielschneider.atmsimulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ranielschneider.atmsimulator.data.users
import com.ranielschneider.atmsimulator.model.User
import com.ranielschneider.atmsimulator.ui.LoginScreen
import com.ranielschneider.atmsimulator.ui.theme.ATMSimulatorTheme

val currentUser = users.find { it.nome == "John Doe" }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            enableEdgeToEdge()

        setContent {
            ATMSimulatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen()
                }
            }
        }
    }
}




