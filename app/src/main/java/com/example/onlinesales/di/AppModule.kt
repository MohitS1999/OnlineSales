package com.example.onlinesales.di

import android.app.Application
import androidx.room.Room
import com.example.onlinesales.api.MathApi
import com.example.onlinesales.db.HistoryDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // it will provide the object of room database
    @Singleton
    @Provides
    fun provideHistoryDB(app:Application) : HistoryDB{
        return Room.databaseBuilder(app,HistoryDB::class.java,"historyDB").build()
    }
    //IT will provide the object of retrofit API
    @Provides
    @Singleton
    fun providesRetrofit() : MathApi =
        Retrofit.Builder()
            .baseUrl(MathApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MathApi::class.java)
}