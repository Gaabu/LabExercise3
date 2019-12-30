package com.example.labexercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Calbutton: Button = findViewById(R.id.buttonCalculate)
        val ResetButton: Button = findViewById(R.id.buttonReset)

        Calbutton.setOnClickListener { calInsurance(it) }
        ResetButton.setOnClickListener { reset(it) }
    }

    private fun calInsurance(view: View){
        val ages = findViewById<Spinner>(R.id.spinnerAge).selectedItemPosition + 1
        val rGroup = findViewById<RadioGroup>(R.id.radioGroupGender).checkedRadioButtonId
        val gender = findViewById<RadioButton>(rGroup).text

        val smoker = findViewById<CheckBox>(R.id.checkBoxSmoker)

        var insurance = 0
        if(ages == 1){
            insurance += 60
        }else if(ages == 2){
            insurance += 70

            if(gender == "Male"){
                insurance += 50
            }
            if(smoker.isChecked){
                insurance += 100
            }
        }else if(ages == 3) {
            insurance += 90

            if (gender == "Male") {
                insurance += 100
            }
            if (smoker.isChecked) {
                insurance += 150
            }
        }else if(ages == 4) {
            insurance += 120

            if (gender == "Male") {
                insurance += 150
            }
            if (smoker.isChecked) {
                insurance += 200
            }
        }else if(ages == 5) {
            insurance += 150

            if (gender == "Male") {
                insurance += 200
            }
            if (smoker.isChecked) {
                insurance += 250
            }
        }else if(ages == 6) {
            insurance += 150

            if (gender == "Male") {
                insurance += 200
            }
            if (smoker.isChecked) {
                insurance += 300
            }
        }
        textViewPremium.text = "Total Insurance Premium : $insurance"

    }

    private fun reset(view: View){
        spinnerAge.setSelection(0)
        radioGroupGender.check(R.id.radioButtonMale)
        checkBoxSmoker.isChecked = false
        textViewPremium.text = "Insurance Premium :"
    }
}
