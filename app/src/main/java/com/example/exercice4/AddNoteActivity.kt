package com.example.exercice4

import android.widget.Toast
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.addtaskactivity.*


class AddNoteActivity : AppCompatActivity() {

    private var editTextTask: EditText? = null
    private var editTextDesc: EditText? = null
    private var color: EditText ? = null
    private var date: DatePicker ? = null
    var saveBtn: Button ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addtaskactivity)

        editTextTask = findViewById(R.id.editTextTask)
        editTextDesc = findViewById(R.id.editTextDesc)
        color = findViewById(R.id.editTextColor)
        date = findViewById(R.id.simpleDatePicker)
        saveBtn = findViewById<Button>(R.id.button_save)
        saveBtn!!.setOnClickListener{
            saveTask()
        }

    }

    private fun saveTask() {
        val sTask = editTextTask!!.text.toString().trim { it <= ' ' }
        val sDesc = editTextDesc!!.text.toString().trim { it <= ' ' }
        val scolor = editTextColor!!.text.toString().trim { it <= ' ' }
        val sdate: String = "" +simpleDatePicker.year + "-" + simpleDatePicker.month + "-" +simpleDatePicker.dayOfMonth

        if (sTask.isEmpty()) {
            editTextTask!!.error = "Title required"
            editTextTask!!.requestFocus()
            return
        }

        if (sDesc.isEmpty()) {
            editTextDesc!!.error = "Description required"
            editTextDesc!!.requestFocus()
            return
        }

        if (scolor.isEmpty()) {
            editTextColor!!.error = "Color required"
            editTextColor!!.requestFocus()
            return
        }

        class SaveTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {

                //creating a task
                val task = note()
                task.setTitre(sTask)
                task.setDescription(sDesc)
                task.setColor(scolor)
               task.setDate(sdate)


                //adding to database
                DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                    .taskDao()
                    .insert(task)
                return null
            }

            override fun onPostExecute(aVoid: Void?) {
                super.onPostExecute(aVoid)
                finish()
                startActivity(Intent(applicationContext, MainActivity::class.java))
                Toast.makeText(applicationContext, "Saved", Toast.LENGTH_LONG).show()
            }
        }

        val st = SaveTask()
        st.execute()
    }

}