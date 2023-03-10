package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class solicitarVideoConsulta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitar_video_consulta)
        val btn = findViewById<Button>(R.id.solicitarVideoConsul)
        btn.setOnClickListener {
            val intent = Intent(this, consultaVideo::class.java)
            startActivity(intent)
        }
    }
}