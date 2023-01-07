package com.example.ejercicio2_2023_2.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface swApi {
    @GET()
    fun getSwPersonajes(
        @Url url: String?
    ): Call <personajeSw>

    @GET()
    fun getSwPlaneta(
        @Url url: String?
    ): Call <planetaSw>

    /*@GET("api/people/{id}/?format=json")
    fun getSwDetail(
        @Path("id") id: String?
    ): Call<personajeSw>*/
}