package com.example.taller1

import com.google.gson.annotations.SerializedName

data class Pais (@SerializedName("capital")
                 val capital: String?=null,
                 @SerializedName("nombre")
                 val nombre: String,
                 @SerializedName("nombreInter")
                 val nombreInter: String,
                 @SerializedName("sigla")
                 val sigla: String,
                 @SerializedName("urlImg")
                 val urlImg: String){

}

