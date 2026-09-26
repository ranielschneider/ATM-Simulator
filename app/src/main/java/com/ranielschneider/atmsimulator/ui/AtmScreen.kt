package com.ranielschneider.atmsimulator.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ranielschneider.atmsimulator.model.User
import java.math.BigDecimal

@Composable
fun AtmScreen(user: User) {

    var depositAmount by remember { mutableStateOf("") }
    var balance by remember { mutableStateOf(user.balance) }
    var depositError by remember { mutableStateOf("") }
    var withdrawAmount by remember { mutableStateOf("") }
    var withdrawError by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(balance.toString())

        TextField(
            value = depositAmount,
            onValueChange = { depositAmount = it },
            label = {
                Text("Valor do depósito")
            }
        )
        if(depositError.isNotEmpty()){
            Text(depositError)
        }

        Button(onClick = {
            val amount = depositAmount.toBigDecimalOrNull()

            if(amount != null && amount > BigDecimal.ZERO){
                balance = user.balance.add(amount)
                user.balance = balance
                depositError = ""
            }else{
                depositError = "Valor inválido"
            }

        }) {
            Text("Depositar")
        }

        TextField(
            value = withdrawAmount,
            onValueChange = {withdrawAmount = it},
            label = {
                Text("Valor do levantamento")
            }
        )

        Button(onClick = {
            val amount = withdrawAmount.toBigDecimalOrNull()

            if (amount != null && amount > BigDecimal.ZERO) {

                if (amount <= balance) {
                    balance = balance.subtract(amount)
                    user.balance = balance
                    withdrawError = ""
                } else {
                    withdrawError = "Saldo insuficiente"
                }

            } else {
                withdrawError = "Valor inválido"
            }

        }) {
            Text("Levantar")
        }

        Button(onClick = {}) {
            Text("Sair")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AtmPreview() {
    AtmScreen(
        User("John Doe", 1234, BigDecimal("1000.00"))
    )
}