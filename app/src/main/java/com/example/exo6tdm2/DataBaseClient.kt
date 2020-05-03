package com.example.exo6tdm2

import android.content.Context
import androidx.room.Room


class DatabaseClient private constructor(private val mCtx: Context) {

    //our app database object
    val appDatabase: AppDatabase

    init {

        //creating the app database with Room database builder
        //MesSeances is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "MesSeances").build()
    }

    companion object {
        private var mInstance: DatabaseClient? = null

        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance as DatabaseClient
        }

        fun getAppDatabase(databaseClient: DatabaseClient): AppDatabase {
            return databaseClient.appDatabase
        }
    }

}