package com.example.proyecto_movipet


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyecto_movipet.databinding.RegistroMascotaBinding



class RegistroMascota : AppCompatActivity() {

    private lateinit var binding: RegistroMascotaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RegistroMascotaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnContinuar.setOnClickListener {
            val intent = Intent(this, Confirmar_foto::class.java)
            startActivity(intent)
        }
    }
}


