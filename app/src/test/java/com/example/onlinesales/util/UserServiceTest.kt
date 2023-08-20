package com.example.onlinesales.util

import com.example.onlinesales.model.LOGIN_STATUS
import com.example.onlinesales.respository.UserRepository
import com.example.onlinesales.respository.UserService
import com.nhaarman.mockitokotlin2.anyVararg
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class UserServiceTest {
    @Mock
    lateinit var userRepository: UserRepository


    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(userRepository.loginUser(anyVararg(), anyVararg())).thenReturn(LOGIN_STATUS.INVALID_PASSWORD)
    }

    @Test
    fun testUserService(){
        val sut = UserService(userRepository)
        val res = sut.loginUser("abc@gmail.com","1111111")
        Assert.assertEquals("Password is invalid",res)
    }

}