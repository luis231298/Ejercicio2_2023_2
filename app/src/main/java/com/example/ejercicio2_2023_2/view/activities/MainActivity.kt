package com.example.ejercicio2_2023_2.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ejercicio2_2023_2.databinding.ActivityMainBinding
import com.example.ejercicio2_2023_2.model.personajeSw
import com.example.ejercicio2_2023_2.model.swApi
import com.example.ejercicio2_2023_2.view.adapters.Adapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://swapi.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val call = retrofit.create(swApi::class.java).getSwPersonajes("api/people/?format=json")
            call.enqueue(object: Callback<personajeSw>{
                override fun onResponse(
                    call: Call<personajeSw>,
                    response: Response<personajeSw>
                ) {
                    /*Toast.makeText(this@MainActivity, "Nombre: ${response.body()?.name}", Toast.LENGTH_LONG).show()
                            binding.nombreSw.setText(response.toString())*/
                    //binding.nombreSw.visibility = View.GONE
                    //Toast.makeText(this@MainActivity,"Conectado",Toast.LENGTH_SHORT).show()
                    binding.rvMenu.layoutManager = LinearLayoutManager(this@MainActivity)
                    binding.rvMenu.adapter = Adapter(this@MainActivity,response.body()!!.results)
                    binding.pbCarga.visibility = View.GONE
                    //binding.nombreSw.visibility = View.VISIBLE
                    //binding.nombreSw.setText(response.body()?.results?.get(0)?.name)
                }

                override fun onFailure(call: Call<personajeSw>, t: Throwable) {
                    binding.pbCarga.visibility = View.GONE
                    Toast.makeText(this@MainActivity,"Error de conexión: ${t.message}",Toast.LENGTH_SHORT).show()
                    binding.nombreSw.setText(t.message)
                }

            })
        }

    }
}