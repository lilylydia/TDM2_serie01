package com.example.exo1_sharedpref

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat



class MainActivity : AppCompatActivity() {
    private var mColor: Int = 0
    private val COLOR_KEY = "color"
    var sh: SharedPreferences? = null


    private var mPreferences: SharedPreferences? = null
    private val sharedPrefFile = "com.example.android.hellosharedprefs"

    private var actOne: Button? =null
    private var actTwo: Button? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialiser la couleur

        mColor = ContextCompat.getColor(this, R.color.default_background);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);


        actOne = findViewById(R.id.actone)
        actTwo = findViewById(R.id.acttwo)

        actOne!!.setOnClickListener{
            val intent = Intent(this@MainActivity, activityOne::class.java)
            intent.putExtra("Color", mColor)
            startActivity(intent)
        }
        actTwo!!.setOnClickListener{
            val intent = Intent(this@MainActivity, activityTwo::class.java)
            intent.putExtra("Color", mColor)
            startActivity(intent)
        }

        mColor = ContextCompat.getColor(this, R.color.default_background)
        // Restore the saved instance state.
        if (savedInstanceState != null) {

            mColor = savedInstanceState.getInt(COLOR_KEY)


        }
    }
  // to save shared preferences
    override fun onPause() {
      super.onPause()
      val preferencesEditor = mPreferences!!.edit()
      preferencesEditor.putInt(COLOR_KEY, mColor)
      preferencesEditor.apply()
      preferencesEditor.commit()
    }
    fun changeBackground (view: View){

        val color = (view.background as ColorDrawable).color

        mColor = color
        sh = getSharedPreferences("Color", mColor)
        val pref = applicationContext.getSharedPreferences("Color", 0) // 0 - for private mode
        val editor = pref.edit()
        editor.putString("Color", mColor.toString())
        editor.commit()
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putInt(COLOR_KEY, mColor)
    }

}
