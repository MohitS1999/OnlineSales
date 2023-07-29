package com.example.onlinesales.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.onlinesales.model.History

@Database(entities = [History::class], version = 1)
abstract class HistoryDB : RoomDatabase(){

    abstract fun getHistoryDao() : HistoryDao



}