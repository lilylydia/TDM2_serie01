package com.example.exo6tdm2

import androidx.room.RoomDatabase
import androidx.room.Database
import androidx.room.TypeConverters


@Database(entities = arrayOf(Seance::class), version = 1 , exportSchema = false)

abstract class AppDatabase : RoomDatabase() {
    abstract fun SeanceDao(): SeanceDao
}