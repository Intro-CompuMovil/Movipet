package com.example.proyecto_movipet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConfirmacionRegistro : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmacion_registro)

        val btn = findViewById<Button>(R.id.btn_continuar)
        btn.setOnClickListener{
            val intent = Intent(this, MenuServicios::class.java)
            startActivity(intent)
        }

        val btn2 = findViewById<Button>(R.id.btn_agregar_otra_mascota)
        btn2.setOnClickListener{
            val intent = Intent(this, RegistroMascota::class.java)
            startActivity(intent)
        }
    }
}