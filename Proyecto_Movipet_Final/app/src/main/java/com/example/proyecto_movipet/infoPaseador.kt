package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class infoPaseador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_paseador)
        val btn = findViewById<Button>(R.id.contPaseador)
        btn.setOnClickListener {
            val intent = Intent(this, mapaPaseador::class.java)
            startActivity(intent)

        }
        val btn2 = findViewById<Button>(R.id.cancelarsoliPaseador)
        btn2.setOnClickListener {
            val intent = Intent(this, servicioCancelado::class.java)
            startActivity(intent)
        }
    }}