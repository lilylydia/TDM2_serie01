package com.example.exo6tdm2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity
class Seance: Serializable {

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "Jour")
    private var Jour: String? = null

    @ColumnInfo(name = "heureDeb")
    private var heureDeb: String? = null

    @ColumnInfo(name = "heureFin")
    private var heureFin: String? = null

    @ColumnInfo(name = "module")
    private var module: String? = null

    @ColumnInfo(name = "sale")
    private var sale: String? = null

    @ColumnInfo(name = "enseignant")
    private var enseignant: String? = null
    /*
    * Getters and Setters
    * */
    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getJour(): String? {
        return Jour
    }

    fun setJour(Jour: String) {
        this.Jour = Jour
    }

    fun getHeureDeb(): String? {
        return heureDeb
    }

    fun setHeureDeb(heureDeb: String){
        this.heureDeb = heureDeb
    }
    fun getHeureFin(): String? {
        return heureFin
    }
    fun setHeureFin(heureFin: String) {
        this.heureFin= heureFin
    }

    fun getModule(): String? {
        return module
    }

    fun setModule(module: String) {
        this.module= module
    }

    fun getSale(): String? {
        return sale
    }

    fun setSale(sale: String) {
        this.sale= sale
    }

    fun getEnseignant(): String? {
        return enseignant
    }

    fun setEnseignant(enseignant: String) {
        this.enseignant= enseignant
    }

}

class groupe : Serializable{
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "groupe")
    private var groupe: String? = null

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getGroupe(): String? {
        return groupe
    }

    fun setGroupe(groupe: String) {
        this.groupe = groupe
    }
}