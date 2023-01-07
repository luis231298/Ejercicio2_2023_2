package com.example.ejercicio2_2023_2.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2_2023_2.databinding.SwPersonajeBinding
import com.example.ejercicio2_2023_2.model.Results
import com.example.ejercicio2_2023_2.view.activities.MainActivity

class Adapter(private val contecto: Context, private val personajeSw: ArrayList<Results>): RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: SwPersonajeBinding): RecyclerView.ViewHolder(view.root) {
        val nombre = view.tvNombre
        val altura = view.tvAltura
        val anio = view.tvAnio
        val genero = view.tvGenero
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SwPersonajeBinding.inflate(LayoutInflater.from(contecto))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nombre.text = personajeSw[position].name
        holder.altura.text = personajeSw[position].height
        holder.anio.text = personajeSw[position].birth_year
        holder.genero.text = personajeSw[position].gender

        holder.itemView.setOnClickListener{
            if (contecto is MainActivity) contecto.selectedPersonaje(personajeSw[position])
        }
    }

    override fun getItemCount(): Int = personajeSw.size
}