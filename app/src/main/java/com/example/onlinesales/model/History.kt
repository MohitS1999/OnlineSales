package com.example.onlinesales.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "history")
data class History (
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val input:String,
    val output:String,
    val date:String
) : Serializable
