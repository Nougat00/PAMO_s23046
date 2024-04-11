package pl.edu.pjatk.lab_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.lang3.StringUtils;

public class BMICalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);
        EditText editTextHeight = findViewById(R.id.height);
        EditText editTextWeight = findViewById(R.id.weight);
        Button buttonSubmit = findViewById(R.id.submit);
        TextView textViewResult = findViewById(R.id.result);

        buttonSubmit.setOnClickListener(v -> {
            if (!StringUtils.isAnyEmpty(editTextWeight.getText(), editTextHeight.getText())) {
                float height = Float.parseFloat(editTextHeight.getText().toString()) / 100;
                float weight = Float.parseFloat(editTextWeight.getText().toString());
                float result = weight / (height * height);
                BmiLabelAndColor bmiLabelAndColor = BmiLabelAndColor.getBmiLabelAndColor(result);
                textViewResult.setTextColor(bmiLabelAndColor.color);
                textViewResult.setText(bmiLabelAndColor.label);
                Utils.hideKeyboard(this, findViewById(android.R.id.content));
            } else {
                textViewResult.setTextColor(Color.RED);
                textViewResult.setText("One of fields is empty");
                Utils.hideKeyboard(this, findViewById(android.R.id.content));
            }
        });
    }

    public static class BmiLabelAndColor {
        String label;
        int color;

        public BmiLabelAndColor(String label, int color) {
            this.label = label;
            this.color = color;
        }

        public static BmiLabelAndColor getBmiLabelAndColor(float result) {
            if (result < 18.5) {
                return new BmiLabelAndColor(result + "\nUnderweight", Color.BLUE);
            } else if (result > 18.6 && result < 24.9) {
                return new BmiLabelAndColor(result + "\nNormal", Color.GREEN);
            } else if (result > 25.0 && result < 29.9) {
                return new BmiLabelAndColor(result + "\nOverweight", Color.YELLOW);
            } else if (result > 30.0 && result < 34.9) {
                return new BmiLabelAndColor(result + "\nObese", Color.rgb(255, 128, 0));
            }
            return new BmiLabelAndColor(result + "\nExtremely obese", Color.RED);
        }
    }

    public void openHomeActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}