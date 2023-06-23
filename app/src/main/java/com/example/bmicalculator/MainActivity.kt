package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightText = findViewById<EditText>(R.id.etHeight)
        val weightText = findViewById<EditText>(R.id.etWeight)
        val proceedButton = findViewById<Button>(R.id.btnProceed)
        val resultText = findViewById<TextView>(R.id.tvResult)

        proceedButton.setOnClickListener {
            val height = heightText.text.toString().toFloat()
            val weight = weightText.text.toString().toFloat()

            if (height == 0.0f && weight == 0.0f) {
                resultText.text = "Invalid result"
            } else {
                val bmi = (weight / ((height/100) * (height/100)))
                val bmiInText = String.format("%.2f", bmi).toFloat() // 2 decimal

                displayResult(bmiInText)
            }
        }
    }

    private fun displayResult (bmi: Float) {
        val resultText = findViewById<TextView>(R.id.tvResult)
        val descriptionText = findViewById<TextView>(R.id.tvDescription)

        resultText.text = bmi.toString()

        when {
            bmi < 18.5 -> descriptionText.text = "You are skinny, eat more!"
            bmi > 24.9 -> descriptionText.text = "You are too fat, stop eating!!!"
            else -> descriptionText.text = "Your health is good!"
        }
    }
}