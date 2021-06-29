package edu.cabokotlinlab2021.tp1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.cabokotlinlab2021.tp1.model.Temperature

class TemperatureViewModel : ViewModel() {

    val temperature = MutableLiveData<Temperature>()
    val error = MutableLiveData<Boolean>()

    fun convertTemperature(value: Double, unit: Char) {
        val temp = Temperature(value, unit)
        if (temp.validateTemperature()) {
            temperature.postValue(temp.convertTemperature())
        } else error.postValue(false)
    }


}
