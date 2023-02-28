package com.example.taller1

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStream

class paises : AppCompatActivity() {

    fun getJsonDataFromAsset(): String? {
        var json: String?=null
        try {
            val istream: InputStream = assets.open("paises.json")
            val size: Int = istream.available()
            val buffer = ByteArray(size)
            istream.read(buffer)
            istream.close()
            json = String(buffer,Charsets.UTF_8)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return json
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paises)
        val jsonFileString = getJsonDataFromAsset()



    }
}