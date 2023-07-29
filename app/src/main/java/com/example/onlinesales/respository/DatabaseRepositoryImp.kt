package com.example.onlinesales.respository

import android.util.Log
import com.example.onlinesales.db.HistoryDB
import com.example.onlinesales.model.History
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val TAG = "DatabaseRepositoryImp"
class DatabaseRepositoryImp(
    private val database:HistoryDB
) : DatabaseRepository{

    override suspend fun saveDataInDatabase(list:List<History>) {
        Log.d(TAG, "saveDataInDatabase: ${list.size}")
        database.getHistoryDao().insertHistory(list)

    }
            

}