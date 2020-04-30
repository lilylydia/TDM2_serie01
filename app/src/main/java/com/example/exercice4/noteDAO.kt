package com.example.exercice4

import androidx.room.*


@Dao
interface TaskDao {

    @Query("SELECT * FROM note")

    fun getAll(): List<note>

    @Insert
    fun insert(task: note)

    @Delete
    fun delete(task: note)

    @Update
    fun update(task: note)

}