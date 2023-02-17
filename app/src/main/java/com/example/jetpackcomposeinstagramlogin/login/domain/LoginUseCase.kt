package com.example.jetpackcomposeinstagramlogin.login.domain

import com.example.jetpackcomposeinstagramlogin.login.data.LoginRepository

class LoginUseCase {

    private val repository = LoginRepository()

    suspend operator fun invoke(user:String, password:String):Boolean{
        return repository.doLogin(user,password)
    }

}