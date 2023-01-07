package com.example.ejercicio2_2023_2.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2_2023_2.databinding.SwPlanetaBinding
import com.example.ejercicio2_2023_2.model.Results
import com.example.ejercicio2_2023_2.model.planetaSw

class AdapterPlanet (private val contecto: Context, private val planetaSw: ArrayList<planetaSw>): RecyclerView.Adapter<AdapterPlanet.ViewHolder>(){

    class ViewHolder(view: SwPlanetaBinding): RecyclerView.ViewHolder(view.root) {
        val nombre = view.tvPlaneta
        val rot = view.periodoRotacion
        val orb = view.periodoOrbital
        val diametro = view.diametro
        val clima = view.clima
        val terreno = view.terreno
        val habitantes = view.cantidadHabitantes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPlanet.ViewHolder {
        val binding = SwPlanetaBinding.inflate(LayoutInflater.from(contecto))
        return AdapterPlanet.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterPlanet.ViewHolder, position: Int) {
        holder.nombre.text = planetaSw[position].name
        holder.rot.text = planetaSw[position].rotationPeriod
        holder.orb.text = planetaSw[position].orbitalPeriod
        holder.diametro.text = planetaSw[position].diameter
        holder.clima.text = planetaSw[position].climate
        holder.terreno.text = planetaSw[position].terrain
        holder.habitantes.text = planetaSw[position].population
    }

    override fun getItemCount(): Int = planetaSw.size

}