package com.example.onlinesales.util

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper : Helper
    @Before
    fun setup(){
        //Arrange
        helper = Helper()
        println("before")
    }

    @After
    fun tearDown(){
        println("after")
    }

    @Test
    fun isPalindrome() {

        //Act
        val result = helper.isPalindrome("level")
        //Assert
        assertEquals(true,result)
    }
    @Test
    fun isPalindrome_inputString_level_expectedtrue() {
        //Arrange
        //val helper = Helper()
        //Act
        val result = helper.isPalindrome("levele")
        //Assert
        assertEquals(false,result)
    }
}