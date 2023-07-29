package com.example.onlinesales.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlinesales.db.HistoryDB
import com.example.onlinesales.model.History
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val TAG = "MainViewModel"
@HiltViewModel
class MainViewModel  @Inject constructor(
    private val dbRepository: HistoryDB
) :ViewModel(){

     fun saveData(list:List<History>){
         Log.d(TAG, "saveData: ${dbRepository.javaClass.name}")

         viewModelScope.launch (Dispatchers.IO){
             for(item in list)
             dbRepository.getHistoryDao().insertHistory(item)
         }



     }
}