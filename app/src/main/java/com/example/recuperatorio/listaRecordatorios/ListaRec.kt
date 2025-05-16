package com.example.recuperatorio.listaRecordatorios

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp

@Composable
fun listaScreen(viewModel: ListaRecViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        viewModel.cargarRecordatorios()
    }

    val recordatorios by viewModel.listaflow.collectAsState()
    var n = 0

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Lista de Recordatorios",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn {
            items(recordatorios) { rec ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Recordatorio: "+(n+1).toString(), fontSize = 18.sp)
                        Text("Nombre: ${rec.nombre}", fontSize = 18.sp)
                        Text("Fecha: ${rec.fecha}")
                        Text("Importancia: ${rec.importancia}")
                    }
                }
                n += 1
            }
        }
    }
}