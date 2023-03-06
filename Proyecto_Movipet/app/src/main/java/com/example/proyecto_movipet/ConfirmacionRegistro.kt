package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConfirmacionRegistro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirmacion_registro)
        val btn = findViewById<Button>(R.id.btn_continuar)
        btn.setOnClickListener{
            val intent = Intent(this, MenuServicios::class.java)
            startActivity(intent)


}
    }
}