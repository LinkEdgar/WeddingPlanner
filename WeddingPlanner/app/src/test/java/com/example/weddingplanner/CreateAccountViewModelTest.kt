package com.example.weddingplanner

import com.example.weddingplanner.ViewModels.CreateAccountFragmentViewModel
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class CreateAccountViewModelTest {


    var viewModel: CreateAccountFragmentViewModel? = null

    @Before
    fun init(){
        viewModel = CreateAccountFragmentViewModel()
    }

    @Test
    fun testEmailGenericEmail(){
        assertTrue(viewModel!!.isEmailValid("email@test.com"))

    }

    @Test
    fun testMalformedEmail(){
        assertFalse(viewModel!!.isEmailValid("email"))

    }

    @Test
    fun testEmailWithNoPeriod(){
        assertFalse(viewModel!!.isEmailValid("email@testcom"))

    }

    @Test
    fun testEmailToShort(){
        assertFalse(viewModel!!.isEmailValid("e@testcom"))
    }


    @Test
    fun testPasswordLengthSuccess(){
        assertTrue(viewModel!!.isPasswordValid("1234567"))
    }

    @Test
    fun testPasswordLengthFailure(){
        assertFalse(viewModel!!.isPasswordValid("1234"))
    }

    @Test
    fun testPasswordMatchGenericSuccess(){
        assertTrue(viewModel!!.doPasswordsMatch("1234567", "1234567"))
    }

    @Test
    fun testPasswordMatchGenericFailure(){
        assertFalse(viewModel!!.doPasswordsMatch("1234", "1234567"))
    }

    @Test
    fun testPasswordMatchWithSpaces(){
        assertFalse(viewModel!!.doPasswordsMatch("1234567", "1234567 "))
    }







}