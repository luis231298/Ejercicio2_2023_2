package com.example.ejercicio2_2023_2.model

import com.google.gson.annotations.SerializedName

data class planetaSw(
    @SerializedName("name"            ) var name           : String?           = null,
    @SerializedName("rotation_period" ) var rotationPeriod : String?           = null,
    @SerializedName("orbital_period"  ) var orbitalPeriod  : String?           = null,
    @SerializedName("diameter"        ) var diameter       : String?           = null,
    @SerializedName("climate"         ) var climate        : String?           = null,
    @SerializedName("terrain"         ) var terrain        : String?           = null,
    @SerializedName("population"      ) var population     : String?           = null,
)
