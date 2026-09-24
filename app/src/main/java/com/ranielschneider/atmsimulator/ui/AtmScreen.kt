package com.ranielschneider.atmsimulator.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ranielschneider.atmsimulator.model.User
import java.math.BigDecimal


@Composable
fun AtmScreen(user: User) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Saldo")

        Button(onClick = {}) {
            Text("Depositar")
        }

        Button(onClick = {}) {
            Text("Levantar")
        }

        Button(onClick = {}) {
            Text("Sair")
        }çopsam
    }
}

@Preview(showBackground = true)
@Composable
fun AtmPreview() {
    AtmScreen(
        User("John Doe", 1234, BigDecimal("1000.00"))
    )
}