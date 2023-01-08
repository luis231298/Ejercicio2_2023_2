package com.example.ejercicio2_2023_2.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ejercicio2_2023_2.databinding.SwPelisBinding
import com.example.ejercicio2_2023_2.databinding.SwPlanetaBinding
import com.example.ejercicio2_2023_2.model.planetaSw
import java.util.ArrayList

class AdapterPelis(private val contecto: Context, private val pelisSw: ArrayList<String>?): RecyclerView.Adapter<AdapterPelis.ViewHolder>(){

    class ViewHolder(view: SwPelisBinding): RecyclerView.ViewHolder(view.root) {
        val imPeli = view.ivPelicula
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPelis.ViewHolder {
        val binding = SwPelisBinding.inflate(LayoutInflater.from(contecto))
        return AdapterPelis.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val link =pelislink(pelisSw?.get(position))
        Glide.with(contecto).load(link).into(holder.imPeli)

    }

    override fun getItemCount(): Int = pelisSw!!.size

}

fun pelislink(pelisSw: String?): String {

    if (pelisSw == "https://swapi.dev/api/films/1/"){
        return "https://aulavirtual.amaurypm.com/cm2023-1/sw1.jpg"
    }else if(pelisSw == "https://swapi.dev/api/films/2/"){
        return "https://aulavirtual.amaurypm.com/cm2023-1/sw2.jpg"
    }else if(pelisSw =="https://swapi.dev/api/films/3/"){
        return "https://aulavirtual.amaurypm.com/cm2023-1/sw3.jpg"
    }else if(pelisSw == "https://swapi.dev/api/films/4/"){
        return "https://aulavirtual.amaurypm.com/cm2023-1/sw4.jpg"
    }else if(pelisSw == "https://swapi.dev/api/films/5/"){
        return "https://aulavirtual.amaurypm.com/cm2023-1/sw5.jpg"
    }else if(pelisSw =="https://swapi.dev/api/films/6/"){
        return "https://aulavirtual.amaurypm.com/cm2023-1/sw6.jpg"
    }
    return ""
}