package com.example.incrementoapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.incrementoapp.model.AuthResult
import com.example.incrementoapp.model.AuthViewModel

@Composable
fun LoginScreen(viewModel: AuthViewModel = viewModel()) {

    val state = viewModel.authState
    var username by rememberSaveable { mutableStateOf(" ") }
    var password by rememberSaveable { mutableStateOf(" ") }

    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        TextField(value = username, onValueChange = {username = it},
            label = { Text("Username") }

        )
        Spacer(modifier=Modifier.fillMaxSize())
        TextField(value = password, onValueChange = {password = it},
            label = { Text("Password") }

        )
        Spacer(modifier=Modifier.fillMaxSize())
        Button(onClick = { viewModel.login(username, password) }) {

            Text("Conectarse")

        }

        Spacer(modifier=Modifier.fillMaxSize())
        when(state){
            is AuthResult.Idle -> Text("ingrese credenciales")
            is AuthResult.Loading -> CircularProgressIndicator()
            is AuthResult.Success -> Text("Bienvenido, ${state.user.name}")
            is AuthResult.Error -> Text("Error: ${state.message}",color = Color.Red )
        }

    }



}