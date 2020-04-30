package com.example.exercice4

import android.widget.DatePicker
import java.io.Serializable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.sql.Date
import androidx.room.Entity


@Entity
class note: Serializable {

    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0

    @ColumnInfo(name = "titre")
    private var titre: String? = null

    @ColumnInfo(name = "description")
    private var description: String? = null

    @ColumnInfo(name = "date")
    private var date: String? = null

    @ColumnInfo(name = "Color")
    private var color: String? = null

    /*
    * Getters and Setters
    * */
    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getTitre(): String? {
        return titre
    }

    fun setTitre(task: String) {
        this.titre = task
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(desc: String){
        this.description = desc
    }
    fun getDate(): String? {
        return date
    }
    fun setDate(date: String) {
        this.date= date
    }

    fun getColor(): String? {
        return color
    }

    fun setColor(color: String) {
        this.color= color
    }

}