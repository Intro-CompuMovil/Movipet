package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class infoVeterinario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_veterinario)

        val btn = findViewById<Button>(R.id.solivet)
        btn.setOnClickListener {
            val intent = Intent(this, mapa::class.java)
            startActivity(intent)

        }
    }
}