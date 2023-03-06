package com.example.taller1

import java.io.Serializable


class Pais(
    var capital: String,
    var nombre: String,
    var nombreInter: String,
    var sigla: String,
    var urlImg: String
) :
    Serializable {

    override fun toString(): String {
        return nombre
    }
}

