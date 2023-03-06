package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistroMascota : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_mascota)
        val btn = findViewById<Button>(R.id.btn_agregarMascota)
        btn.setOnClickListener{
            val intent = Intent(this, ConfirmacionRegistro::class.java)
            startActivity(intent)
        }
    }
}