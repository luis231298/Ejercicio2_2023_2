package com.example.ejercicio2_2023_2.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.ejercicio2_2023_2.databinding.ActivityInfoPeliculasSwBinding
import com.example.ejercicio2_2023_2.databinding.ActivityInfoPersoSwBinding
import com.example.ejercicio2_2023_2.view.adapters.AdapterPelis
import com.example.ejercicio2_2023_2.view.adapters.AdapterPlanet

class infoPeliculasSw : AppCompatActivity() {

    private lateinit var binding: ActivityInfoPeliculasSwBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInfoPeliculasSwBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundles = intent.extras
        val pelis = bundles?.getStringArrayList("pelis")

        binding.rvPelis.layoutManager = LinearLayoutManager(this@infoPeliculasSw)
        binding.rvPelis.adapter = AdapterPelis(this@infoPeliculasSw,pelis)
        binding.pbCarga.visibility = View.GONE

        //Toast.makeText(this@infoPeliculasSw,pelis?.size.toString(), Toast.LENGTH_LONG).show()

        //Glide.with(this@infoPeliculasSw).load(pelis?.get(0).toString()).into(binding.rvPelis)

    }
}