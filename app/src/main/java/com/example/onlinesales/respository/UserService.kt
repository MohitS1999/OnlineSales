package com.example.onlinesales.respository

import com.example.onlinesales.model.LOGIN_STATUS
import com.example.onlinesales.util.CheckPassword

class UserService(private val userRepository: UserRepository) {

    fun loginUser(name:String,password: String) : String {
        val status = userRepository.loginUser(name,password)
        return when(status){
            LOGIN_STATUS.INVALID_USER -> "User does not exist"
            LOGIN_STATUS.INVALID_PASSWORD -> "Password is invalid"
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown error occurred"
            LOGIN_STATUS.SUCCESS -> "logged is successfully"
        }
    }

}