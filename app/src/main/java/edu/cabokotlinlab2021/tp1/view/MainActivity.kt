package edu.cabokotlinlab2021.tp1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import edu.cabokotlinlab2021.tp1.R

class MainActivity : AppCompatActivity() {

    lateinit var problemOne: Button
    lateinit var problemTwo: Button
    lateinit var problemThree: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeElements()

        problemOne.setOnClickListener {
            val intent = Intent(this, PalindromeActivity::class.java)
            startActivity(intent)
        }
        problemTwo.setOnClickListener {
            val intent = Intent(this, TemperatureActivity::class.java)
            startActivity(intent)
        }
        problemThree.setOnClickListener {
            val intent = Intent(this, FibonacciActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initializeElements() {
        problemOne = findViewById(R.id.b_problem1)
        problemTwo = findViewById(R.id.b_problem2)
        problemThree = findViewById(R.id.b_problem3)
    }
}