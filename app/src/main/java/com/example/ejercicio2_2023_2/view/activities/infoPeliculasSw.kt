package com.example.ejercicio2_2023_2.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejercicio2_2023_2.databinding.ActivityInfoPeliculasSwBinding
import com.example.ejercicio2_2023_2.databinding.ActivityInfoPersoSwBinding

class infoPeliculasSw : AppCompatActivity() {

    private lateinit var binding: ActivityInfoPeliculasSwBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInfoPeliculasSwBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}