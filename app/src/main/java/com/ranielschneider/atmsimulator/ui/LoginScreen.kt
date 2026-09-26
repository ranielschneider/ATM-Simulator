package com.ranielschneider.atmsimulator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ranielschneider.atmsimulator.data.users
import com.ranielschneider.atmsimulator.model.User


@Composable
fun LoginScreen() {

    var name by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    var passWord by remember { mutableStateOf("") }
    var isLoggedIn by remember { mutableStateOf(false) }
    var loggedUser by remember { mutableStateOf<User?>(null) }

    if(isLoggedIn){
        AtmScreen(loggedUser!!)

    }else{

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "ATM Simulator",
            fontSize = 30.sp
        )

        TextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text(
                    "Nome",
                    fontSize = 16.sp
                )
            }
        )

        TextField(
            value = passWord,
            onValueChange = { passWord = it },
            label = {
                Text(
                    "Senha",
                    fontSize = 16.sp
                )
            }
        )

        Button(
            onClick = {

                val user = users.find { it.nome == name }

                if (user != null) {

                    val passwordNumber = passWord.toIntOrNull()

                    if (passwordNumber != null) {

                        if (passwordNumber == user.passWord) {
                            isLoggedIn = true
                            loggedUser = user

                        } else {
                            errorMessage = "Senha incorreta"
                        }

                    } else {
                        errorMessage = "Senha inválida"
                    }

                } else {
                    errorMessage = "Usuário não encontrado"
                }
            }
        ) {
            Text("Entrar")
        }

        if (errorMessage.isNotEmpty()) {
            Text(errorMessage)
        }
    }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}