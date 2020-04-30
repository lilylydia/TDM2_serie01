package com.example.exercice4

import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.TypeConverters


@Database(entities = arrayOf(note::class), version = 1 , exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}