package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class infoVetVideo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_vet_video)
        val btn = findViewById<Button>(R.id.soliVetvi)
        btn.setOnClickListener {
            val intent = Intent(this, videoConsulta::class.java)
            startActivity(intent)

        }
        val btn2 = findViewById<Button>(R.id.cancelarsoliVideo)
        btn2.setOnClickListener {
            val intent = Intent(this, servicioCancelado::class.java)
            startActivity(intent)
        }
    }}