package com.example.onlinesales.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val input:String,
    val output:String,
    val date:String
)
