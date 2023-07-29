package com.example.onlinesales.di

import android.app.Application
import androidx.room.Room
import com.example.onlinesales.db.HistoryDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideHistoryDB(app:Application) : HistoryDB{
        return Room.databaseBuilder(app,HistoryDB::class.java,"historyDB").build()
    }

}