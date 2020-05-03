package com.example.exo6tdm2

import com.google.gson.annotations.SerializedName

data class SeanceClass(
    @SerializedName("id")
    val id : Int,
    @SerializedName("Module")
    var module: String,
    @SerializedName("Jour")
    var jour: String,
    @SerializedName("HeureDeb")
    var heureDeb: String,
    @SerializedName("HeureFin")
    val heureFin: String,
    @SerializedName("Salle")
    val salle: String,
    @SerializedName("Enseignant")
    var enseignant: String
)
