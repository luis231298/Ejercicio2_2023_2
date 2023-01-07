package com.example.ejercicio2_2023_2.view.activities

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio2_2023_2.databinding.ActivityInfoPersoSwBinding
import com.example.ejercicio2_2023_2.model.personajeSw
import com.example.ejercicio2_2023_2.model.planetaSw
import com.example.ejercicio2_2023_2.model.swApi
import com.example.ejercicio2_2023_2.view.adapters.Adapter
import com.example.ejercicio2_2023_2.view.adapters.AdapterPlanet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class infoPersoSw : AppCompatActivity() {

    private lateinit var binding: ActivityInfoPersoSwBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityInfoPersoSwBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundles = intent.extras
        val url = bundles?.getString("url","")

        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val call = retrofit.create(swApi::class.java).getSwPlaneta("?format=json")
            call.enqueue(object: Callback<planetaSw> {
                override fun onResponse(
                    call: Call<planetaSw>,
                    response: Response<planetaSw>
                ) {
                    val arraylist = ArrayList<planetaSw>()

                    arraylist.add(planetaSw(response.body()!!.name,response.body()!!.rotationPeriod,
                    response.body()!!.orbitalPeriod,response.body()!!.diameter,response.body()!!.climate,
                    response.body()!!.terrain,response.body()!!.population))

                    binding.rvCambio.layoutManager = LinearLayoutManager(this@infoPersoSw)
                    binding.rvCambio.adapter = AdapterPlanet(this@infoPersoSw,arraylist)
                    binding.pbCarga.visibility = View.GONE
                    //binding.nombreSw.visibility = View.VISIBLE
                    //binding.nombreSw.setText(response.body()?.results?.get(0)?.name)
                }

                override fun onFailure(call: Call<planetaSw>, t: Throwable) {
                    binding.pbCarga.visibility = View.GONE
                    Toast.makeText(this@infoPersoSw,"Error de conexión: ${t.message}", Toast.LENGTH_SHORT).show()
                    //binding.nombreSw.setText(t.message)
                }

            })
        }

        /*binding.rvCambio.layoutManager = LinearLayoutManager(this@infoPersoSw)
        binding.rvCambio.adapter = AdapterPlanet(this@infoPersoSw,response.body()!!.results)*/
    }
}