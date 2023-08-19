package com.example.onlinesales.util

class CheckPassword {

    fun checkStringPassword(password: String) : Boolean{
        return if (password.isEmpty()) false
        else{
            password.length >= 6
        }
    }

    fun checkReverseString(str:String) : String{
        return  str.reversed()
    }

}