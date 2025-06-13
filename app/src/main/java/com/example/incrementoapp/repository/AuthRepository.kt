package com.example.incrementoapp.repository

import com.example.incrementoapp.model.LoginRequest
import com.example.incrementoapp.model.LoginResponse
import com.example.incrementoapp.network.AuthApi

class AuthRepository (private val api: AuthApi) {
    suspend fun login(username:String, password:String):
            Result<LoginResponse> {
        return try {
            val response = api.login(LoginRequest(username, password))
            if (response.isSuccessful) {
                response.body()?.let { Result.success(it) }
                    ?: Result.failure(Exception("Respuesta vacia"))
            } else {
                Result.failure(Exception("Error en la respuesta del servidor"))
            }
        }
            catch(e: Exception) {
                Result.failure(e)
            }
        }
    }
