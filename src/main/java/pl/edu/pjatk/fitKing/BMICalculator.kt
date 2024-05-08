package pl.edu.pjatk.fitKing

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.apache.commons.lang3.StringUtils

class BMICalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalculator)
        val editTextHeight = findViewById<EditText>(R.id.height)
        val editTextWeight = findViewById<EditText>(R.id.weight)
        val buttonSubmit = findViewById<Button>(R.id.submit)
        val textViewResult = findViewById<TextView>(R.id.result)
        buttonSubmit.setOnClickListener { v: View? ->
            if (!StringUtils.isAnyEmpty(editTextWeight.getText(), editTextHeight.getText())) {
                val height = editTextHeight.getText().toString().toFloat() / 100
                val weight = editTextWeight.getText().toString().toFloat()
                val result = weight / (height * height)
                val bmiLabelAndColor = BmiLabelAndColor.getBmiLabelAndColor(result)
                textViewResult.setTextColor(bmiLabelAndColor.color)
                textViewResult.text = bmiLabelAndColor.label
                Utils.hideKeyboard(this, findViewById(android.R.id.content))
            } else {
                textViewResult.setTextColor(Color.RED)
                textViewResult.text = "One of fields is empty"
                Utils.hideKeyboard(this, findViewById(android.R.id.content))
            }
        }
    }

    class BmiLabelAndColor(@JvmField var label: String, @JvmField var color: Int) {
        companion object {
            @JvmStatic
            fun getBmiLabelAndColor(result: Float): BmiLabelAndColor {
                if (result < 18.5) {
                    return BmiLabelAndColor("$result\nUnderweight", Color.BLUE)
                } else if (result > 18.6 && result < 24.9) {
                    return BmiLabelAndColor("$result\nNormal", Color.GREEN)
                } else if (result > 25.0 && result < 29.9) {
                    return BmiLabelAndColor("$result\nOverweight", Color.YELLOW)
                } else if (result > 30.0 && result < 34.9) {
                    return BmiLabelAndColor("$result\nObese", Color.rgb(255, 128, 0))
                }
                return BmiLabelAndColor("$result\nExtremely obese", Color.RED)
            }
        }
    }

    fun openHomeActivity(view: View?) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}