package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class solicitarConsulta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitar_consulta)
        val btn = findViewById<Button>(R.id.solicitarConsul)
        btn.setOnClickListener{
            val intent = Intent(this, consultaDomicilio::class.java)
            startActivity(intent)
        }
    }
}