package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Pago : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago)
        val btn = findViewById<Button>(R.id.fin)
        btn.setOnClickListener{
            val intent = Intent(this, exitoso::class.java)
            startActivity(intent)
        }
    }
}