package com.example.exo6tdm2

import androidx.room.*



@Dao
interface SeanceDao {

    @Query("SELECT * FROM Seance")

    fun getAll(): List<Seance>

    @Insert
    fun insert(task: Seance)

    @Delete
    fun delete(task: Seance)

    @Update
    fun update(task: Seance)

}