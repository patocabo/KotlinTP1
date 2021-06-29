package edu.cabokotlinlab2021.tp1.model

import java.io.Serializable

data class Temperature(val value: Double, val unit: Char) : Serializable {

    fun convertTemperature(): Temperature{
        return if (this.unit == 'C') {
            celciusToFarenheit()
        } else farenheitToCelcius()
    }

    private fun celciusToFarenheit(): Temperature {
        return Temperature(this.value * 9 / 5 + 32, 'F')
    }

    private fun farenheitToCelcius(): Temperature {
        return Temperature((this.value - 32) * 5 / 9, 'C')
    }

    fun validateTemperature(): Boolean {
        return !((this.value < -273.15 && this.unit == 'C')
                || (this.value < -459.67 && this.unit == 'F'))
    }
}
