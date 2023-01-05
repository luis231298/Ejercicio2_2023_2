package com.example.ejercicio2_2023_2.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface swApi {
    @GET("api/people/{id}/?format=json")
    fun getSwDetail(
        @Path("id") id: String?
    ): Call<personajeSw>
}