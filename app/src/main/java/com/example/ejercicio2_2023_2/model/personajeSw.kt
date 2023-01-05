package com.example.ejercicio2_2023_2.model

import com.google.gson.annotations.SerializedName

data class personajeSw(
    @SerializedName("name")
    var name: String? = null
)

/*class Results{
    @SerializedName("0")
    var personaje: Personaje? = null
}

class Personaje {
    @SerializedName("name")
    var name: String? = null
}*/
