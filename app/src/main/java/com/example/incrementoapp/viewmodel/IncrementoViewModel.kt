package com.example.incrementoapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class IncrementoViewModel: ViewModel(){

    var state by mutableStateOf(0)
    private set

    fun incrementar(){
        state++
    }

    fun decrementar(){
        state--
    }
}