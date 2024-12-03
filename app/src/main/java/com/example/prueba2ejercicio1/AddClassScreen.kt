package com.example.prueba2ejercicio1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddClassScreenFull() {
    var className by remember { mutableStateOf("") }
    var selectedDay by remember { mutableStateOf("") }
    var expandedDay by remember { mutableStateOf(false) }
    val daysOfWeek = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

    var selectedTime by remember { mutableStateOf("") }
    var expandedTime by remember { mutableStateOf(false) }
    val times = listOf("08:00", "10:00", "12:00", "14:00", "16:00", "18:00", "20:00")

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Añadir Clase",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = className,
                onValueChange = { className = it },
                label = { Text("Nombre de la Asignatura") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            // Dropdown para Día de la Semana
            ExposedDropdownMenuBox(
                expanded = expandedDay,
                onExpandedChange = { expandedDay = !expandedDay }
            ) {
                OutlinedTextField(
                    value = selectedDay,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Día de la Semana") },
                    modifier = Modifier
                        .menuAnchor() // Ancla para el menú desplegable
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDay)
                    }
                )
                ExposedDropdownMenu(
                    expanded = expandedDay,
                    onDismissRequest = { expandedDay = false }
                ) {
                    daysOfWeek.forEach { day ->
                        DropdownMenuItem(
                            text = { Text(text = day) },
                            onClick = {
                                selectedDay = day
                                expandedDay = false
                            }
                        )
                    }
                }
            }

            // Dropdown para Hora
            ExposedDropdownMenuBox(
                expanded = expandedTime,
                onExpandedChange = { expandedTime = !expandedTime }
            ) {
                OutlinedTextField(
                    value = selectedTime,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Hora") },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedTime)
                    }
                )
                ExposedDropdownMenu(
                    expanded = expandedTime,
                    onDismissRequest = { expandedTime = false }
                ) {
                    times.forEach { time ->
                        DropdownMenuItem(
                            text = { Text(text = time) },
                            onClick = {
                                selectedTime = time
                                expandedTime = false
                            }
                        )
                    }
                }
            }

            Button(
                onClick = {
                    // Manejar el guardado de la información aquí
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(text = "Guardar")
            }
        }
    }
}
