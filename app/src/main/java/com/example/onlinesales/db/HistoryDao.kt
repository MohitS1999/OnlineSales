package com.example.onlinesales.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.onlinesales.model.History


@Dao
interface HistoryDao {

    @Insert
    suspend fun insertHistory(history: History)

    @Query("select * from history")
    fun getContact(): LiveData<List<History>>

}