package com.example.exo1_sharedpref

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class activityTwo : AppCompatActivity() {

    val mypreference = "Color"
    private var setting: Button? =null
    private var mColor: Int = 0
    private val COLOR_KEY = "color"
    private var mPreferences: SharedPreferences? = null
    private val sharedPrefFile = "com.example.android.hellosharedprefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        setting = findViewById(R.id.Settings)


        mColor = ContextCompat.getColor(this, R.color.default_background);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Restore preferences
        val view = this.window.decorView
        mColor = mPreferences!!.getInt(COLOR_KEY, mColor)
        view.setBackgroundColor(mColor)
    }
}



