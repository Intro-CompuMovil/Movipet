package com.example.taller1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etGuess_game = findViewById<EditText>(R.id.editText_guess_game)
        val buttonGuess = findViewById<Button>(R.id.btn_guess_game)
        val buttonPais = findViewById<Button>(R.id.btn_countries)
        val buttonGreet = findViewById<Button>(R.id.btn_random_greet)
        val spinnerGreet = findViewById<Spinner>(R.id.spn_random_greet)

        ArrayAdapter.createFromResource(
            this,
            R.array.idiomas,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerGreet.adapter = adapter

        }


        buttonGuess.setOnClickListener{

            val intent = Intent(this, Guess_game::class.java)
            val nlimite = etGuess_game.text.toString()

            if (TextUtils.isEmpty(nlimite)) {
                Toast.makeText(this, "Try again , empty ", Toast.LENGTH_SHORT).show()
            } else {
                if(Integer.parseInt(nlimite)>1000||Integer.parseInt(nlimite)<0){
                    Toast.makeText(this, "Insert a correct number ", Toast.LENGTH_SHORT).show()
                }else{
                    intent.putExtra("numeroLimite",nlimite )
                    startActivity(intent)
                }

            }

        }
        buttonPais.setOnClickListener{
            val intent = Intent(this, paises::class.java)
            startActivity(intent)
        }
        buttonGreet.setOnClickListener{

            val intent = Intent(this, Greetings::class.java)
            var input: String = spinnerGreet.selectedItem.toString()
            intent.putExtra("idioma",input )
            startActivity(intent)
        }

    }



}