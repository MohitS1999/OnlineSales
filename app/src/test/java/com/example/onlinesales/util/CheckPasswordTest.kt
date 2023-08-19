package com.example.onlinesales.util

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class CheckPasswordTest {

    lateinit var checkPassword: CheckPassword

    @Before
    fun setUp(){
        checkPassword = CheckPassword()
    }

    @Test
    fun checkReverseString_input_empty_true(){
        val result = checkPassword.checkReverseString("")
        assertEquals("",result)
    }
    @Test
    fun checkReverseString_input_abc_true(){
        val result = checkPassword.checkReverseString("abc")
        assertEquals("cba",result)
    }

    @Test
    fun checkStringPassword_inputString_empty_false() {
        // arrange

        //act
        val res = checkPassword.checkStringPassword("")
        // assert
        assertEquals(false,res)
    }
    @Test
    fun checkStringPassword_inputString_short_length_false() {
        // arrange

        //act
        val res = checkPassword.checkStringPassword("adsa")
        // assert
        assertEquals(false,res)
    }
    @Test
    fun  checkStringPassword_inputString_correct_true() {
        // arrange

        //act
        val res = checkPassword.checkStringPassword("fdsfasfsdf")
        // assert
        assertEquals(true,res)
    }
}