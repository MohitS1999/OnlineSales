package com.example.onlinesales.respository

import com.example.onlinesales.model.LOGIN_STATUS
import com.example.onlinesales.model.User

class UserRepository {

    val users = listOf<User>(
        User(1,"John","john1000"),
        User(2,"Mohn","mohn1000"),
        User(3,"Sohn","sohn1000")
    )

    fun loginUser(name:String,password:String) : LOGIN_STATUS {
        val users = users.filter { user ->user.name == name }
        return if (users.size == 1){
            if (users[0].password == password) LOGIN_STATUS.SUCCESS
            else LOGIN_STATUS.INVALID_PASSWORD
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }

}