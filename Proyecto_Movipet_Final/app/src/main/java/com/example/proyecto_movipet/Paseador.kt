package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Paseador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paseador)
        val btn = findViewById<Button>(R.id.soliPase)
        btn.setOnClickListener {
            val intent = Intent(this, buscarPaseador::class.java)
            startActivity(intent)


        }
    }
}