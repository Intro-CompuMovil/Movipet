package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InfoVeterinario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_veterinario)

        val btn = findViewById<Button>(R.id.solivet)
        val btn2 = findViewById<Button>(R.id.cancelarSoli)

        btn.setOnClickListener {
            val intent = Intent(this, Mapa::class.java)
            startActivity(intent)

        }
        btn2.setOnClickListener {
            val intent = Intent(this, servicioCancelado::class.java)
            startActivity(intent)

        }
    }

}