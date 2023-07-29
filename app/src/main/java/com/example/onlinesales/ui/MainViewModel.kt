package com.example.onlinesales.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinesales.db.HistoryDB
import com.example.onlinesales.model.History
import com.example.onlinesales.model.RequestBody
import com.example.onlinesales.respository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val TAG = "MainViewModel"
@HiltViewModel
class MainViewModel  @Inject constructor(
    private val dbRepository: DatabaseRepository
) :ViewModel(){

     fun saveData(list:List<History>){
         Log.d(TAG, "saveData: ${dbRepository.javaClass.name} size := ${list.size}")
            viewModelScope.launch (Dispatchers.IO){
                dbRepository.saveDataInDatabase(list)
            }
     }
    fun getDataFromDB():List<History>{
        var result = emptyList<History>()
        viewModelScope.launch (Dispatchers.IO){
            result = dbRepository.getDataFromDB()
        }
        Thread.sleep(500)
        return result
    }



    fun callApi(data:List<String>) : List<String>{
        var result = emptyList<String>()
        viewModelScope.launch(Dispatchers.IO) {
           result = dbRepository.getResultFromApi(RequestBody(data, 14)).body()?.result ?: emptyList()
        }
        Thread.sleep(1000)
        return result

    }
}