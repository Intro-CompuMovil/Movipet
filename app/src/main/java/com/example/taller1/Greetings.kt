package com.example.taller1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Greetings : AppCompatActivity() {
    fun saludo (input:String): String {
        var output : String = "No paso nada"
        if(input=="Español")
        {
            output = "¿Hola , como estas?"
        }
        if(input=="Inglés")
        {
            output = "Hi, how are you?"
        }
        if(input=="Alemán")
        {
            output = "Hallo, wie geht es dir?"
        }
        if(input=="Japones")
        {
            output = "こんにちは、元気ですか？"
        }
        if(input=="Italiano")
        {
            output ="Ciao, come stai?"
        }
        if(input=="Francés")
        {
            output = "Bonjour, comment allez-vous?"
        }
        return output
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greetings)
        val elSaludo = findViewById<TextView>(R.id.elSaludo)
        val input:String = intent.getStringExtra("idioma").toString()
        var output: String = saludo(input)
        elSaludo.text = output




    }
}