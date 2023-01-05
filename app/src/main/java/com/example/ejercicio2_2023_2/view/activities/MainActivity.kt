package com.example.ejercicio2_2023_2.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.ejercicio2_2023_2.databinding.ActivityMainBinding
import com.example.ejercicio2_2023_2.model.personajeSw
import com.example.ejercicio2_2023_2.model.swApi
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

            val call = retrofit.create(swApi::class.java).getSwDetail("1")
            call.enqueue(object: Callback<personajeSw>{
                override fun onResponse(call: Call<personajeSw>, response: Response<personajeSw>) {

                    Toast.makeText(this@MainActivity, "Nombre: ${response.body()?.name}", Toast.LENGTH_LONG).show()
                    binding.nombreSw.setText(response.toString())
                }

                override fun onFailure(call: Call<personajeSw>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

    }
}