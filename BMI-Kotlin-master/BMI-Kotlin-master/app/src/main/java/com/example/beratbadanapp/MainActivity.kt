package com.example.beratbadanapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {


    private  var gender: String = "Laki - Laki"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextName = findViewById<EditText>(R.id.editTextName1) // Add this line
        val editTextAlamat = findViewById<EditText>(R.id.editTextAlamat) // Add this
        val editTextTelepon = findViewById<EditText>(R.id.editTextTelepon)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)

        buttonCalculate.setOnClickListener {
            calculateBMI(editTextHeight, editTextWeight, editTextName, editTextAlamat, editTextTelepon, radioGroupGender, textViewResult)
        }

        buttonReset.setOnClickListener {
            resetForm(editTextHeight, editTextWeight, editTextName, editTextAlamat, editTextTelepon, radioGroupGender, textViewResult)
        }


    }

    private fun calculateBMI(
        editTextHeight: EditText,
        editTextWeight: EditText,
        editTextName: EditText,
        editTextAlamat: EditText,
        editTextTelepon: EditText,
        radioGroupGender: RadioGroup,
        textViewResult: TextView
    ) {
        val height = editTextHeight.text.toString().toDouble()
        val weight = editTextWeight.text.toString().toDouble()
        val name = editTextName.text.toString() // Add this line
        val alamat = editTextAlamat.text.toString()
        val telp = editTextTelepon.text.toString().toDouble()
        val selectedGenderId = radioGroupGender.checkedRadioButtonId

        gender = when (selectedGenderId) {
            R.id.radioButtonMale -> "Laki-laki"
            R.id.radioButtonFemale -> "Perempuan"
            else -> "Laki-laki"

        }
        val bmi = when (gender) {
            "Laki-laki" -> weight / ((height / 100) * (height / 100))
            "Perempuan" -> weight / ((height / 100) * (height / 100)) * 0.9
            else -> 0.0
            }
        val result = when {
            bmi < 18.5 -> "Berat badan kurang"
            bmi >= 18.5 && bmi < 24.9 -> "Berat badan normal"
            bmi >= 25 && bmi < 29.9 -> "Berat badan berlebih"
            else -> "Obesitas"
            }
            textViewResult.text = "Nama: $name\nAlamat: $alamat\nTelp: $telp\nBMI: %.2f\n$result".format(bmi)
        }

    private fun resetForm(
        editTextHeight: EditText,
        editTextWeight: EditText,
        editTextName: EditText,
        editTextAlamat: EditText,
        editTextTelepon: EditText,
        radioGroupGender: RadioGroup,
        textViewResult: TextView
    ) {
        editTextHeight.text.clear()
        editTextWeight.text.clear()
        editTextName.text.clear()
        editTextAlamat.text.clear()
        editTextTelepon.text.clear()
        radioGroupGender.clearCheck()
        textViewResult.text = ""
    }
}

