package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.proyecto_movipet.databinding.RegistroMascotaBinding

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val btn = findViewById<Button>(R.id.btn_entrar2)

        btn.setOnClickListener{
            val intent = Intent(this, RegistroMascota::class.java)
            startActivity(intent)
        }
    }
}