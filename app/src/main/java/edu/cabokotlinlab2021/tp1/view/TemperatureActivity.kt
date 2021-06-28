package edu.cabokotlinlab2021.tp1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import edu.cabokotlinlab2021.tp1.R

class TemperatureActivity : AppCompatActivity() {
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        initializeSpinner()

    }

    private fun initializeSpinner(){
        spinner = findViewById(R.id.s_unit)
        ArrayAdapter.createFromResource(
            this,
            R.array.temperature_units,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }
}