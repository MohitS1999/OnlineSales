package com.example.onlinesales.respository

import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.onlinesales.api.MathApi
import com.example.onlinesales.db.HistoryDB
import com.example.onlinesales.model.History
import com.example.onlinesales.model.RequestBody
import com.example.onlinesales.model.ResultBody
import retrofit2.Call
import retrofit2.Callback;
import retrofit2.Response


private const val TAG = "DatabaseRepositoryImp"
class DatabaseRepositoryImp(
    private val database:HistoryDB,
    private val mathApi: MathApi
) : DatabaseRepository{

    override suspend fun saveDataInDatabase(list:List<History>) {
        Log.d(TAG, "saveDataInDatabase: ${list.size}")
        database.getHistoryDao().insertHistory(list)

    }

    override suspend fun getResultFromApi(data:RequestBody) : Response<ResultBody>{
        Log.d(TAG, "getResultFromApi: ${mathApi.javaClass.name}")
        return mathApi.getData(data)
    }



}