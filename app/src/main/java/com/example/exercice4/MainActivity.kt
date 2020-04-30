package com.example.exercice4


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.AsyncTask
import android.content.Intent
import android.R.*
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercice4.DatabaseClient.Companion.getAppDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton



class MainActivity : AppCompatActivity() {

    private var buttonAddTask: FloatingActionButton? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview_tasks)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        buttonAddTask = findViewById(R.id.floating_button_add)
        buttonAddTask!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                val intent = Intent(this@MainActivity, AddNoteActivity::class.java)
                startActivity(intent)
            }
        })


        getTasks()

    }


    private fun getTasks() {
        class GetTasks : AsyncTask<Void, Void?, List<note>>() {

            override fun doInBackground(vararg voids: Void): List<note> {
                val notes:List<note> = DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext)).taskDao().getAll()
                return notes
            }

            override fun onPostExecute(notes: List<note>) {
                super.onPostExecute(notes)
                val adapter = TasksAdapter(this@MainActivity, notes)
                recyclerView?.adapter = adapter
            }
        }

        val gt = GetTasks()
        gt.execute()
    }
}
