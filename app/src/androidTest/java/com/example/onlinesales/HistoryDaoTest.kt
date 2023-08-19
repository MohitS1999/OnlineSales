package com.example.onlinesales

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.core.app.ApplicationProvider
import com.example.onlinesales.db.HistoryDB
import com.example.onlinesales.db.HistoryDao
import com.example.onlinesales.model.History
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HistoryDaoTest {



    lateinit var historyDB:HistoryDB
    lateinit var historyDao: HistoryDao

    @Before
    fun setUp(){
        historyDB = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            HistoryDB::class.java
        ).allowMainThreadQueries().build()
        historyDao = historyDB.getHistoryDao()
    }

    @Test
    fun insertHistory_expectedSingleHistory() = runBlocking{
        val history = History(0,"mohit","singh","20aug2023")
        val list = listOf<History>(history)
        historyDao.insertHistory(list)
        val result = historyDao.getHistoryData()
        assertEquals(1,result.size)
        assertEquals("mohit",result[0].input)
    }

    @After
    fun tearDown(){
        historyDB.close()
    }

}