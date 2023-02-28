package com.example.taller1

import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Guess_gameActivity : AppCompatActivity() {
    var counterInt: Int = 0

    fun game(intento:String,aleatorio:Int): String {
        val intentoInt: Int = Integer.parseInt(intento)
        var output:String=""
        if(intentoInt==aleatorio){
            output = "you win"
        }
        if(intentoInt<aleatorio){
            output="$intento is smaller"
        }
        if(intentoInt>aleatorio){
            output="$intento is bigger"
        }
        counterInt = counterInt+1
        return output
    }
    fun check(intento:String,limiteInt:Int):Boolean{
        val intentoInt:Int = Integer.parseInt(intento)
        if(TextUtils.isEmpty(intento)){
            return false
        }
        if(intentoInt>limiteInt||intentoInt<0){
            return false
        }
        return true
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        val input:String = intent.getStringExtra("numeroLimite").toString()
        setContentView(R.layout.activity_guess_game)
        val buttonPlay = findViewById<Button>(R.id.button)
        val intento = findViewById<EditText>(R.id.editTextNumber)
        val txtView = findViewById <TextView> (R.id.txtView_guess_game)
        val message = findViewById<TextView>(R.id.message)
        val counter = findViewById<TextView>(R.id.counter)
        txtView.text = input
        val limiteInt: Int = Integer.parseInt(input)
        val randomInt:Int = Random.nextInt(from = 0, until = limiteInt)
        var output : String = ""
        super.onCreate(savedInstanceState)

        buttonPlay.setOnClickListener{
            var intentoText : String = intento.text.toString()
            if(check(intentoText,limiteInt)){
                output= game(intentoText,randomInt)
                counter.text= counterInt.toString()
                message.text = output
            }else{
                Toast.makeText(this, "Insert a correct number ", Toast.LENGTH_SHORT).show()
            }

        }


    }
}