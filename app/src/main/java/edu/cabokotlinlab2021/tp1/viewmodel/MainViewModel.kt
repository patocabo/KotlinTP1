package edu.cabokotlinlab2021.tp1.viewmodel

import android.widget.Button
import androidx.lifecycle.ViewModel
import edu.cabokotlinlab2021.tp1.R

class MainViewModel : ViewModel() {
    private fun navigate(button: Button) {
        when (button.id) {
            R.id.b_problem1 -> println()
            R.id.b_problem2 -> println()
            R.id.b_problem3 -> println()
        }
    }
}