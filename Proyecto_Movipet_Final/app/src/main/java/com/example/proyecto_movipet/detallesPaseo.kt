package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class detallesPaseo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_paseo)
        val btn = findViewById<Button>(R.id.pagarPaseador)
        btn.setOnClickListener{
            val intent = Intent(this, Pago::class.java)
            startActivity(intent)
        }
    }
}