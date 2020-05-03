package com.example.exercice4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.AsyncTask.execute
import android.content.Intent
import android.widget.Toast
import android.os.AsyncTask
import android.content.DialogInterface
import android.R.*
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import kotlinx.android.synthetic.main.updatetaskactivity.*
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.addtaskactivity.*


class updateNoteActivity : AppCompatActivity() {
    private var editTextTask: EditText? = null
    private var editTextDesc: EditText? = null
    private var editTextFinishBy: EditText? = null
    private var editTextdate1: EditText? = null
    private var editTextdate: DatePicker? = null
    var updateBtn: Button?= null
    var deleteBtn: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.updatetaskactivity)

        editTextTask = findViewById(R.id.editTextTask)
        editTextDesc = findViewById(R.id.editTextDesc)
        editTextFinishBy = findViewById(R.id.editTextFinishBy)
        editTextdate = findViewById(R.id.simpleDatePicker)
        editTextdate1 = findViewById(R.id.editTextdate1)

        updateBtn = findViewById(R.id.button_update)
        deleteBtn = findViewById(R.id.button_delete)

        val task = intent.getSerializableExtra("task") as? note

        loadTask(task!!)
        updateBtn!!.setOnClickListener{
            Toast.makeText(applicationContext, "Clicked", Toast.LENGTH_LONG).show()
                  updateTask(task)
        }

        deleteBtn!!.setOnClickListener{
            val builder = AlertDialog.Builder(this@updateNoteActivity)
            builder.setTitle("Are you sure?")
           builder.setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, i -> deleteTask(task) })
            builder.setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i -> })

            val ad = builder.create()
            ad.show()
        }

    }

    private fun loadTask(note1: note) {
        editTextTask?.setText(note1.getTitre())
        println("oui1")
        editTextDesc?.setText(note1.getDescription())
        println("oui2")
        editTextFinishBy?.setText(note1.getColor())
        println("oui3")
        editTextdate1?.setText(note1.getDate())
        println("oui4")


    }

    private fun updateTask(task: note) {
        val sTask = editTextTask!!.getText().toString().trim()
        val sDesc = editTextDesc!!.getText().toString().trim()
        val sFinishBy = editTextFinishBy!!.getText().toString().trim()
        val sdate = editTextdate1!!.getText().toString().trim()
      //  val sdate: String = "" +editTextdate!!.year + "-" + editTextdate!!.month + "-" +editTextdate!!.dayOfMonth
        if (sTask.isEmpty()) {
            editTextTask!!.setError("Note required")
            editTextTask!!.requestFocus()
            return
        }

        if (sDesc.isEmpty()) {
            editTextDesc!!.setError("Description required")
            editTextDesc!!.requestFocus()
            return
        }

        if (sFinishBy.isEmpty()) {
            editTextFinishBy!!.setError("Color required")
            editTextFinishBy!!.requestFocus()
            return
        }

        class UpdateTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {
                task.setTitre(sTask)
                task.setDescription(sDesc)
                task.setColor(sFinishBy)
                task.setDate(sdate)

                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .taskDao()
                    .update(task)
                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                Toast.makeText(applicationContext, "Updated", Toast.LENGTH_LONG).show()
                finish()
                startActivity(Intent(this@updateNoteActivity, MainActivity::class.java))
            }
        }
        val ut = UpdateTask()
        ut.execute()
    }


    fun deleteTask(note:note)
    {
        class DeleteTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .taskDao()
                    .delete(note)
                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                Toast.makeText(applicationContext, "Deleted", Toast.LENGTH_LONG).show()
                finish()
                startActivity(Intent(this@updateNoteActivity, MainActivity::class.java))
            }
        }

        val dt = DeleteTask()
        dt.execute()
    }
}