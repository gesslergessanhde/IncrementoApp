package com.example.incrementoapp.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel() {

    var authState by mutableStateOf<AuthResult>(AuthResult.Idle)
    private set

    fun login( username: String, password: String){

        viewModelScope.launch {
            authState = AuthResult.Loading
            delay(4000)
            if (username == "admin" && password == "1234"){

                val user = User(1, "Administrador", "jwt-token")
                authState = AuthResult.Success(user)
            }
            else{
                authState = AuthResult.Error("Credenciales incorrectas")
            }

        }

    }

}
