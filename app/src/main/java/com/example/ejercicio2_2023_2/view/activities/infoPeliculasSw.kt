package com.example.ejercicio2_2023_2.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.ejercicio2_2023_2.databinding.ActivityInfoPeliculasSwBinding
import com.example.ejercicio2_2023_2.databinding.ActivityInfoPersoSwBinding

class infoPeliculasSw : AppCompatActivity() {

    private lateinit var binding: ActivityInfoPeliculasSwBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInfoPeliculasSwBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundles = intent.extras
        val pelis = bundles?.getStringArrayList("pelis")

        Toast.makeText(this@infoPeliculasSw,pelis?.size.toString(), Toast.LENGTH_LONG).show()

        //Glide.with(this@infoPeliculasSw).load(pelis?.get(0).toString()).into(binding.rvPelis)

    }
}