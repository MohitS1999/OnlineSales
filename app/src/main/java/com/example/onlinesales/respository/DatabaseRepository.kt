package com.example.onlinesales.respository

import com.example.onlinesales.model.History

interface DatabaseRepository {
    suspend fun saveDataInDatabase(list:List<History>)
}