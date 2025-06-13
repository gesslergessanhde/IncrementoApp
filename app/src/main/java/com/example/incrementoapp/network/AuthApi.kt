package com.example.incrementoapp.network

import com.example.incrementoapp.model.LoginRequest
import com.example.incrementoapp.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/usuario/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

}