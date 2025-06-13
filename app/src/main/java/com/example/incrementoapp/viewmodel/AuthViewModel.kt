package com.uam.incrementovm.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.incrementoapp.model.AuthResult
import com.example.incrementoapp.model.User
import com.example.incrementoapp.repository.AuthRepository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: AuthRepository) : ViewModel(){

    private val _authState = MutableStateFlow<AuthResult>(AuthResult.Idle)
    val authState : StateFlow<AuthResult> = _authState

    fun login(username : String, password : String){
        _authState.value = AuthResult.Loading
        viewModelScope.launch {
           val result = repository.login(username, password)

            if (username == "admin" && password == "1234") {
                val user = User(1,"Administrador","jwt-token")
                authState = AuthResult.Success(user)
            }
            else {
                authState = AuthResult.Error("Credenciales incorrectas")
            }
        }
    }

}