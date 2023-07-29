package com.example.onlinesales.respository

import com.example.onlinesales.model.History
import com.example.onlinesales.model.RequestBody
import com.example.onlinesales.model.ResultBody
import retrofit2.Response

interface DatabaseRepository {
    suspend fun saveDataInDatabase(list:List<History>)
    suspend fun getResultFromApi(data:RequestBody) : Response<ResultBody>
}