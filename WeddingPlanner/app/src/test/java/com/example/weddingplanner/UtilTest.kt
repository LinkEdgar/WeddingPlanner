package com.example.weddingplanner

import com.example.weddingplanner.Utils.Util
import com.example.weddingplanner.ViewModels.CreateAccountFragmentViewModel
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class UtilTest {

    @Test
    fun testEmailGenericEmail(){
        assertTrue(Util.isEmailValid("email@test.com"))

    }

    @Test
    fun testMalformedEmail(){
        assertFalse(Util.isEmailValid("email"))

    }

    @Test
    fun testEmailWithNoPeriod(){
        assertFalse(Util.isEmailValid("email@testcom"))

    }

    @Test
    fun testEmailToShort(){
        assertFalse(Util.isEmailValid("e@testcom"))
    }


    @Test
    fun testPasswordLengthSuccess(){
        assertTrue(Util.isPasswordValid("1234567"))
    }

    @Test
    fun testPasswordLengthFailure(){
        assertFalse(Util.isPasswordValid("1234"))
    }

    @Test
    fun testPasswordMatchGenericSuccess(){
        assertTrue(Util.doPasswordsMatch("1234567", "1234567"))
    }

    @Test
    fun testPasswordMatchGenericFailure(){
        assertFalse(Util.doPasswordsMatch("1234", "1234567"))
    }

    @Test
    fun testPasswordMatchWithSpaces(){
        assertFalse(Util.doPasswordsMatch("1234567", "1234567 "))
    }







}