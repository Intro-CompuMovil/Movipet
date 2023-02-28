package com.example.taller1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class paisContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pais_content)
        val nombre = findViewById<TextView>(R.id.nombre)
        val capital = findViewById<TextView>(R.id.capital)
        val inter = findViewById<TextView>(R.id.inter)
        val sigla = findViewById<TextView>(R.id.sigla)
        val bandera = findViewById<ImageView>(R.id.placeHolder)
        val picasso = Picasso.get()


        val intentGet = intent
        val paisShow = intentGet.getSerializableExtra("Pais") as Pais

        nombre.text = paisShow.nombre
        capital.text = paisShow.capital
        inter.text = paisShow.nombreInter
        sigla.text = paisShow.sigla

        picasso.load(paisShow.urlImg).into(bandera)
    }
}