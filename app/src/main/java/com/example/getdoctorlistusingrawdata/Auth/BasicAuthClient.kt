package com.example.getdoctorlistusingrawdata.Auth

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class BasicAuthClient<T> {
    private val client =  OkHttpClient.Builder()
        .callTimeout(60,TimeUnit.MINUTES)
        .addInterceptor(BasicAuthInterceptor("doctor1", "Doctor123"))
        .build()

    val gson = GsonBuilder()
        .setLenient()
        .create();

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://demo.intelehealth.org")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun create(service: Class<T>): T {
        return retrofit.create(service)
    }
}