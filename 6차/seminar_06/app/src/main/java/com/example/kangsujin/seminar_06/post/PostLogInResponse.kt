package com.example.kangsujin.seminar_06.post

data class PostLogInResponse(
        val status : Int,
        val message : String,
        val data : LoginData
)
data class LoginData(
        val token : String
)