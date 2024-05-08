package pl.edu.pjatk.fitKing

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.apache.commons.lang3.StringUtils

class CaloriesToEat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories_to_eat)
        val editTextHeight = findViewById<EditText>(R.id.height)
        val editTextWeight = findViewById<EditText>(R.id.weight)
        val editTextAge = findViewById<EditText>(R.id.age)
        val radioButtonMale = findViewById<RadioButton>(R.id.male)
        val radioGroupGender = findViewById<RadioGroup>(R.id.genderGroup)
        val buttonSubmit = findViewById<Button>(R.id.submit)
        val textViewResult = findViewById<TextView>(R.id.result)
        buttonSubmit.setOnClickListener { v: View? ->
            if (!StringUtils.isAnyEmpty(
                    editTextAge.getText(),
                    editTextHeight.getText(),
                    editTextWeight.getText()
                ) &&
                radioGroupGender.checkedRadioButtonId != -1
            ) {
                val height = editTextHeight.getText().toString().toFloat()
                val weight = editTextWeight.getText().toString().toFloat()
                val age = editTextAge.getText().toString().toFloat()
                val result: String
                result = if (radioButtonMale.isChecked) {
                    (66.47 + 13.7 * weight + 5.0 * height - 6.76 * age).toFloat().toString()
                } else {
                    (655.1 + 9.567 * weight + 1.85 * height - 4.68 * age).toFloat().toString()
                }
                textViewResult.setTextColor(Color.BLACK)
                textViewResult.text = "$result kcal"
                Utils.hideKeyboard(this, findViewById(android.R.id.content))
            } else {
                textViewResult.setTextColor(Color.RED)
                textViewResult.text = "One of fields is empty"
                Utils.hideKeyboard(this, findViewById(android.R.id.content))
            }
        }
    }

    fun openHomeActivity(view: View?) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}