package com.example.ejercicio2_2023_2.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejercicio2_2023_2.databinding.ActivityInfoPersoSwBinding
import com.example.ejercicio2_2023_2.databinding.ActivityMenuSwBinding

private lateinit var binding: ActivityMenuSwBinding

class menuSw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMenuSwBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundles = intent.extras

        val clickPlaneta = binding.btnPlanetas

        val clickPelis = binding.btnPeliculas

        clickPlaneta.setOnClickListener{
            var parametros = Bundle()
            val url = bundles?.getString("planeta","")

            parametros.apply {
                putString("url",url)
            }

            val intent = Intent(this@menuSw,infoPersoSw::class.java)

            intent.putExtras(parametros)

            startActivity(intent)

            //Toast.makeText(this@menuSw, "boton", Toast.LENGTH_SHORT).show()
        }

        clickPelis.setOnClickListener {
            var parametrosPelis = Bundle()
            val pelis = bundles?.getStringArrayList("films")

            parametrosPelis.apply {
                putStringArrayList("pelis",pelis)
            }

            val intent = Intent(this@menuSw,infoPeliculasSw::class.java)

            intent.putExtras(parametrosPelis)

            startActivity(intent)

        }

    }
}