package com.example.onlinesales.di

import androidx.room.Database
import com.example.onlinesales.api.MathApi
import com.example.onlinesales.db.HistoryDB
import com.example.onlinesales.respository.DatabaseRepository
import com.example.onlinesales.respository.DatabaseRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDatabaseRepository(
        database: HistoryDB,
        mathApi:MathApi
    ):DatabaseRepository{
        return DatabaseRepositoryImp(database,mathApi)
    }
}