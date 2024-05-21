package com.nubb.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.math.abs

class MainActivity : ComponentActivity() {
    private lateinit var etName: EditText
    private lateinit var btnGuess: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Set the content view to the XML layout

        // Initialize views
        etName = findViewById(R.id.etName)
        btnGuess = findViewById(R.id.btnGuess)
        tvResult = findViewById(R.id.tvResult)

        // Set up button click listener
        btnGuess.setOnClickListener {
            val name = etName.text.toString().trim()
            if (name.isNotEmpty()) {
                val horoscope = getHoroscopeFromName(name)
                tvResult.text = "$name, your horoscope sign is $horoscope"
            } else {
                tvResult.text = "Please enter your name."
            }
        }
    }

    private fun getHoroscopeFromName(name: String): String {
        // List of horoscopes from strings.xml
        val horoscopes = resources.getStringArray(R.array.horoscope_array)
        // Simple hash function to map name to an index in the horoscope array
        val index = abs(name.hashCode() % horoscopes.size)
        return horoscopes[index]
    }
}
