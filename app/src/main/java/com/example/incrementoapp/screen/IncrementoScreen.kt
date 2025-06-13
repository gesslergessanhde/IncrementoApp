package com.example.incrementoapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.incrementoapp.viewmodel.IncrementoViewModel

@Composable
fun IncrementoScreen(viewModel: IncrementoViewModel = viewModel()){

    val estado = viewModel.state
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

    }

    Text("${estado.toString()}")
    Spacer(modifier = Modifier.height(10.dp))
    Button(onClick = { viewModel.incrementar() }) {
        Text("Incrementar")
    }

}