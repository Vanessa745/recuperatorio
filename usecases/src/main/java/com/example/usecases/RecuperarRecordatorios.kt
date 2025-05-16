package com.example.usecases

import com.example.data.RecordatoriosRepository

class RecuperarRecordatorios(
    val repository: RecordatoriosRepository
) {
    suspend fun invoke() {
        repository.getAllRecordatorios()
    }
}