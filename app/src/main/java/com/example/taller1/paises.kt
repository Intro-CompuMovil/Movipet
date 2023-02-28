package com.example.taller1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class paises : AppCompatActivity() {
    var listaPaises = ArrayList<Pais>()

    fun getJsonDataFromAsset(): String {
        val json: String?
        try {
            val istream: InputStream = assets.open("paises.json")
            val size: Int = istream.available()
            val buffer = ByteArray(size)
            istream.read(buffer)
            istream.close()
            json = String(buffer,Charsets.UTF_8)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null.toString()
        }
        return json
    }
    fun fillArray(){
        val json: JSONObject?
        try {
            json = JSONObject(getJsonDataFromAsset())
            val paisesJsonArray = json!!.getJSONArray("paises")
            for (i in 0 until paisesJsonArray.length()) {
                val jsonObject = paisesJsonArray.getJSONObject(i)
                val capital = jsonObject.getString("capital")
                val nombre = jsonObject.getString("nombre_pais")
                val nombreInt = jsonObject.getString("nombre_pais_int")
                val sigla = jsonObject.getString("sigla")
                val urlImg = jsonObject.getString("url")
                val aux = Pais(capital, nombre, nombreInt, sigla, urlImg)
                Log.d("Pais", aux.toString())
                listaPaises.add(aux)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paises)
        var listaPais = findViewById<ListView>(R.id.listaPais)
        fillArray()

        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listaPaises)
        listaPais.adapter = arrayAdapter
        listaPais.onItemClickListener =
            OnItemClickListener { adapterView, view, i, l ->
                val paisAux: Pais? = arrayAdapter.getItem(i)
                val intentPais = Intent(view.context, paisContent::class.java)
                intentPais.putExtra("Pais", paisAux)
                startActivity(intentPais)
            }



    }
}