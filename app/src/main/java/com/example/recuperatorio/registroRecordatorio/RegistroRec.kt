package com.example.recuperatorio.registroRecordatorio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun registroScreen(viewModel: RegistroRecViewModel = hiltViewModel(), onSuccess : () -> Unit) {
    var nomRec by remember { mutableStateOf("") }
    var fecRec by remember { mutableStateOf("") }
    var impRec by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        verticalArrangement = Arrangement.Center
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(0.dp, 10.dp, 0.dp, 10.dp),
            text = "Ingrese los datos del recordatorio: ",
            fontSize = 20.sp
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = nomRec,
            onValueChange = {
                nomRec = it
            },
            label = {
                Text(
                    "Ingrese el nombre del recordatorio"
                )
            }
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = fecRec,
            onValueChange = {
                fecRec = it
            },
            label = {
                Text(
                    "Ingrese la fecha del recordatorio"
                )
            }
        )

        Column {
            Text(
                modifier = Modifier
                    .padding(0.dp, 10.dp, 0.dp, 10.dp),
                text = "Seleccione la importancia del recordatorio:",
                fontSize = 20.sp
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = impRec == "Normal",
                    onClick = { impRec = "Normal" }
                )
                Text(
                    text = "Normal",
                    fontSize = 18.sp
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = impRec == "Importante",
                    onClick = { impRec = "Importante" }
                )
                Text(
                    text = "Importante",
                    fontSize = 18.sp
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = impRec == "Muy Importante",
                    onClick = { impRec = "Muy Importante" }
                )
                Text(
                    text = "Muy Importante",
                    fontSize = 18.sp
                )
            }
        }

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewModel.guardarRec(nomRec, fecRec, impRec)
            }
        ) {
            Text("Guardar Recordatorio")
        }

        OutlinedButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onSuccess()
            }
        ) {
            Text("Ver Recordatorios")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun RegPreview() {
//    registroScreen()
//}