package com.example.onlinesales.respository

import android.util.Log
import com.example.onlinesales.db.HistoryDB
import com.example.onlinesales.model.History

private const val TAG = "DatabaseRepositoryImp"
class DatabaseRepositoryImp(
    private val database:HistoryDB
) : DatabaseRepository{

    override suspend fun saveDataInDatabase(list: List<History>) {
        Log.d(TAG, "saveDataInDatabase: ")
        for (item in list) {
            Log.d(TAG, "saveDataInDatabase: $item")
            Log.d(TAG, "saveDataInDatabase: Database ${database.javaClass.name}")

                database.getHistoryDao().insertHistory(item)


        }
    }
            

}