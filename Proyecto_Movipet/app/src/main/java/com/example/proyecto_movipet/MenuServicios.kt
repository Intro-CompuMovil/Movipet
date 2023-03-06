package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuServicios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_servicios)
        val btn = findViewById<Button>(R.id.btn_urgencia)
        btn.setOnClickListener{
            val intent = Intent(this, solicitarConsulta::class.java)
            startActivity(intent)
        }
    }
}