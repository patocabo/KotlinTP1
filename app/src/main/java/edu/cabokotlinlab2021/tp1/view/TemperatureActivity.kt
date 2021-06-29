package edu.cabokotlinlab2021.tp1.view

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import edu.cabokotlinlab2021.tp1.R
import edu.cabokotlinlab2021.tp1.viewmodel.TemperatureViewModel


class TemperatureActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var convert: Button
    private lateinit var tempValue: EditText
    private lateinit var resultado: TextView
    private lateinit var temperatureVM: TemperatureViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temperature)
        initializeComponents()
        setupClickListeners()

        temperatureVM = ViewModelProvider(this).get(TemperatureViewModel::class.java)
        setupObservers()

    }

    private fun setupClickListeners() {
        convert.setOnClickListener {
            temperatureVM.convertTemperature(
                tempValue.text.toString().toDouble(),
                spinner.selectedItem.toString().first()
            )
        }
    }

    private fun setupObservers() {
        temperatureVM.temperature.observe(this, { NewTemp ->
            resultado.visibility = TextView.VISIBLE
            (String.format("%.2f",NewTemp.value) + " º" + NewTemp.unit).also { resultado.text = it }
        })

        temperatureVM.error.observe(this, {
            resultado.visibility = TextView.VISIBLE
            resultado.text = "Temperatura Inválida"
            })
    }

    private fun initializeComponents() {
        convert = findViewById(R.id.b_tempconvert)
        tempValue = findViewById(R.id.e_tempvalue)
        resultado = findViewById(R.id.t_result)

        //inicializa spinner
        spinner = findViewById(R.id.s_unit)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.units_array,
            android.R.layout.simple_spinner_item
        )
        spinner.adapter = adapter
    }
}