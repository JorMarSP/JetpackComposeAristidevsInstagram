package com.example.jetpackcomposeinstagramlogin.core.network

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    //Al trabajar con daggerHilt(inyeccion de dependecias) esto ya no es necesario


    /*fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }*/
    /*fun getRetrofit(): Retrofit {
        val result = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        Log.i(result.toString(),"result")
        return result
    }*/

}