package com.example.exo6tdm2

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Groupe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.groupes)

        var gone: TextView = findViewById(R.id.twocp)
        var gtwo: TextView = findViewById(R.id.onecs)
        var gthree: TextView = findViewById(R.id.twocs)
        var gfour: TextView = findViewById(R.id.threecs)

        gone.setText(intent.getStringExtra("groupe1"))
        gtwo.setText(intent.getStringExtra("groupe2"))
        gthree.setText(intent.getStringExtra("groupe3"))
        gfour.setText(intent.getStringExtra("groupe4"))

        gone.setOnClickListener{
            val intent = Intent(this@Groupe,RecyclerView::class.java)
            startActivity(intent)
        }

    }

}