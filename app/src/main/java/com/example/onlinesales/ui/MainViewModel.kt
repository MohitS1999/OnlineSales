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
    init {
        callApi()

    }

    private fun callApi() {
        val list = arrayListOf<String>()
        list.add("a = 1.2 * (2 + 4.5)")
        list.add("a = 1.2 * (2 + 4.5)")
        list.add("a = 1.2 * (2 + 4.5)")
        list.add("a = 1.2 * (2 + 4.5)")
        list.add("a = 1.2 * (2 + 4.5)")
        list.add("a = 1.2 * (2 + 4.5)")
        list.add("a = 1.2 * (2 + 4.5)")
        list.add("a = 1.2 * (2 + 4.5)")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d(TAG, "callApi: $list")
            val response = dbRepository.getResultFromApi(RequestBody(list,14))
            Log.d(TAG, "callApi: ${response.body()}")
        }



    }
}