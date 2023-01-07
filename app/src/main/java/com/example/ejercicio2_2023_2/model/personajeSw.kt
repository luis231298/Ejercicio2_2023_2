package com.example.ejercicio2_2023_2.model

import com.google.gson.annotations.SerializedName

data class personajeSw(
    @SerializedName("results"  )
    var results  : ArrayList<Results> = arrayListOf(),
    /*@SerializedName("count")
    var count: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("height")
    var height: String? = null,
    @SerializedName("birth_year")
    var birth_year: String? = null,
    @SerializedName("gender")
    var gender: String? = null*/
)

class Results {
    @SerializedName("name")
    var name: String? = null
    @SerializedName("height")
    var height: String? = null
    @SerializedName("birth_year")
    var birth_year: String? = null
    @SerializedName("gender")
    var gender: String? = null
    @SerializedName("homeworld")
    var homeworld: String? = null
    @SerializedName("films"      )
    var films     : ArrayList<String> = arrayListOf()
    /*@SerializedName("name")
    var name      : String?           = null,
    @SerializedName("height")
    var height    : String?           = null,
    @SerializedName("mass"       ) var mass      : String?           = null,
    @SerializedName("hair_color" ) var hairColor : String?           = null,
    @SerializedName("skin_color" ) var skinColor : String?           = null,
    @SerializedName("eye_color"  ) var eyeColor  : String?           = null,
    @SerializedName("birth_year" ) var birthYear : String?           = null,
    @SerializedName("gender"     ) var gender    : String?           = null,
    @SerializedName("homeworld"  ) var homeworld : String?           = null,
    @SerializedName("films"      ) var films     : ArrayList<String> = arrayListOf(),
    @SerializedName("species"    ) var species   : ArrayList<String> = arrayListOf(),
    @SerializedName("vehicles"   ) var vehicles  : ArrayList<String> = arrayListOf(),
    @SerializedName("starships"  ) var starships : ArrayList<String> = arrayListOf(),
    @SerializedName("created"    ) var created   : String?           = null,
    @SerializedName("edited"     ) var edited    : String?           = null,
    @SerializedName("url"        ) var url       : String?           = null*/
}


/*class Results{
    @SerializedName("name")
    var personaje: Personaje? = null
}

class Personaje {
    @SerializedName("name")
    var name: String? = null
}*/
