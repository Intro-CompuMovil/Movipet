package com.example.proyecto_movipet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class mapaPaseador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapa_paseador)
        mostrarsiguiente(4000)

    }
    private fun mostrarsiguiente(tiempoDeEspera: Long) {

        val handler = Handler()

        val runnable = Runnable {
            setContentView(R.layout.activity_mapa_paseador)
            handler.postDelayed({
                val intent = Intent(this, llegaPaseador::class.java)
                startActivity(intent)
            }, tiempoDeEspera)
        }
        handler.postDelayed(runnable, 500)
    }
}