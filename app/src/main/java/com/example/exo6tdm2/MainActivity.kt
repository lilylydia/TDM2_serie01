package com.example.exo6tdm2


import android.os.Bundle
import android.widget.TextView
import android.R.*
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //save json data into Room DataBase
        saveTask()

        var Onecp: TextView = findViewById(R.id.onecp)
        var Onecs: TextView = findViewById(R.id.onecs)

        Onecp.setOnClickListener{
            val intent = Intent(this@MainActivity,Groupe::class.java)
            intent.putExtra("groupe1","1CPI1")
            intent.putExtra("groupe2","1CPI2")
            intent.putExtra("groupe3","1CPI3")
            intent.putExtra("groupe4","1CPI4")
            startActivity(intent)
        }
        Onecs.setOnClickListener{
            val intent = Intent(this@MainActivity,Groupe::class.java)
            intent.putExtra("groupe1","1CS1")
            intent.putExtra("groupe2","1CS2")
            intent.putExtra("groupe3","1CS3")
            intent.putExtra("groupe4","1CS4")
            startActivity(intent)
        }


    }
    private fun saveTask() {
        class SaveTask : AsyncTask<Void?, Void?, Void?>() {

            override fun doInBackground(vararg voids: Void?): Void? {

                //get Data from Json File
                val jsonFileString = getJsonDataFromAsset(applicationContext, "list_seance.json")
                Log.i("dataJson", jsonFileString)

                val gson = Gson()
                val listPersonType = object : TypeToken<List<SeanceClass>>() {}.type


                var list_seance: List<SeanceClass> = gson.fromJson(jsonFileString, listPersonType)
                list_seance.forEachIndexed { idx, seance -> Log.i("Seance", "> Item $idx:\n$seance")
                    //creating a task
                    val task = Seance()
                    task.setModule(seance.module)
                    task.setJour(seance.jour)
                    task.setHeureDeb(seance.heureDeb)
                    task.setHeureFin(seance.heureFin)
                    task.setSale(seance.salle)
                    task.setEnseignant(seance.enseignant)

                    DatabaseClient.getAppDatabase(DatabaseClient.getInstance(applicationContext))
                        .SeanceDao()
                        .insert(task)
                }
                return null
            }

        }
        val st = SaveTask()
        st.execute()
    }



}
