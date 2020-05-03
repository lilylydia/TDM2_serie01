package com.example.exo6tdm2

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerView : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview)

        recyclerView = findViewById(R.id.recyclerview_tasks)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        //val adapter = SeanceActivity()
       // recyclerView?.adapter = adapter

        //val adapter = TasksAdapter(this, SeanceActivity)
        //recyclerView?.adapter = adapter

        getSeances()

    }

    private fun getSeances() {
        class GetTasks : AsyncTask<Void, Void?, List<Seance>>() {

            override fun doInBackground(vararg voids: Void): List<Seance> {
                val les_Seances: List<Seance> =
                    DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext)).SeanceDao().getAll()
                return les_Seances
            }

            override fun onPostExecute(les_Seances: List<Seance>) {
                super.onPostExecute(les_Seances)
                val adapter = SeanceActivity(this@RecyclerView, les_Seances)
                recyclerView?.adapter = adapter
            }
        }

        val gt = GetTasks()
        gt.execute()

    }

}