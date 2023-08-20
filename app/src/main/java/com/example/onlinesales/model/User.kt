package com.example.onlinesales.model

data class User(
    val id:Int,
    val name:String,
    val password:String
)

enum class LOGIN_STATUS{
    INVALID_USER,
    INVALID_PASSWORD,
    UNKNOWN_ERROR,
    SUCCESS
}
