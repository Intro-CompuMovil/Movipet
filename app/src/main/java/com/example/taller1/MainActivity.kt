package com.example.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etGuess_game = findViewById<EditText>(R.id.editText_guess_game)
        val buttonGuess = findViewById<Button>(R.id.btn_guess_game)
        val buttonPais = findViewById<Button>(R.id.btn_countries)
        buttonGuess.setOnClickListener{

            val intent = Intent(this, Guess_game::class.java)
            val nlimite = etGuess_game.text.toString()
            intent.putExtra("numeroLimite",nlimite )
            startActivity(intent)
        }
        buttonPais.setOnClickListener{
            val intent = Intent(this, paises::class.java)
            startActivity(intent)
        }

    }



}