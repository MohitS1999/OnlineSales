package com.example.onlinesales.api

import com.example.onlinesales.model.RequestBody
import com.example.onlinesales.model.ResultBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MathApi {

    companion object{
        val BASE_URL = "http://api.mathjs.org/"
    }

    @POST("v4/")
    suspend fun getData(@Body jsonData:RequestBody) : Response<ResultBody>

}