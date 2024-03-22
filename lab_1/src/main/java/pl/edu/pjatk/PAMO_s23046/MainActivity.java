package pl.edu.pjatk.PAMO_s23046;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextHeight = findViewById(R.id.height);
        EditText editTextWeight = findViewById(R.id.weight);
        Button buttonSubmit = findViewById(R.id.submit);
        TextView textViewResult = findViewById(R.id.result);

        buttonSubmit.setOnClickListener(v -> {
            float height = Float.parseFloat(editTextHeight.getText().toString()) / 100;
            float weight = Float.parseFloat(editTextWeight.getText().toString());
            float result = weight / (height * height);
            BmiLabelAndColor bmiLabelAndColor = BmiLabelAndColor.getBmiLabelAndColor(result);
            textViewResult.setTextColor(bmiLabelAndColor.color);
            textViewResult.setText(bmiLabelAndColor.label);
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
}
