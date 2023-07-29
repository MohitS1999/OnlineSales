package com.example.onlinesales.db

import android.support.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.onlinesales.model.History


@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(list:List<History>)

    @Query("delete from history")
    suspend fun deleteAll()

    @Query("select * from history")
    fun getContact(): LiveData<List<History>>

}