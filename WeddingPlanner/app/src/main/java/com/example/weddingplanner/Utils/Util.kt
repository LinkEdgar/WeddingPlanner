package com.example.weddingplanner.Utils

class Util{
    companion object{
        fun isEmailValid(email: String):Boolean {
            if(email.isEmpty() || !email.contains("@") || !email.contains('.')){
                return false
            }
            return true
        }

        fun isNameValid(name: String):Boolean{
            return name.isNotEmpty() && name.length > 1
        }

        fun isPasswordValid(password: String):Boolean{
            return password.isNotEmpty() && password.length > 6 //firebase min length
        }

        fun doPasswordsMatch(password: String, confirmedPass: String):Boolean{
            return password == confirmedPass
        }
    }
}