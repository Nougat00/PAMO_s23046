package pl.edu.pjatk.lab_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.apache.commons.lang3.StringUtils;

public class CaloriesToEat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_to_eat);
        EditText editTextHeight = findViewById(R.id.height);
        EditText editTextWeight = findViewById(R.id.weight);
        EditText editTextAge = findViewById(R.id.age);
        RadioButton radioButtonMale = findViewById(R.id.male);
        RadioGroup radioGroupGender = findViewById(R.id.genderGroup);
        Button buttonSubmit = findViewById(R.id.submit);
        TextView textViewResult = findViewById(R.id.result);


        buttonSubmit.setOnClickListener(v -> {
            if (!StringUtils.isAnyEmpty(editTextAge.getText(),
                    editTextHeight.getText(),
                    editTextWeight.getText()) &&
                    radioGroupGender.getCheckedRadioButtonId() != -1) {
                float height = Float.parseFloat(editTextHeight.getText().toString());
                float weight = Float.parseFloat(editTextWeight.getText().toString());
                float age = Float.parseFloat(editTextAge.getText().toString());
                String result;
                if (radioButtonMale.isChecked()) {
                    result = String.valueOf((float) (66.47 + (13.7 * weight) + (5.0 * height) - (6.76 * age)));
                } else {
                    result = String.valueOf((float) (655.1 + (9.567 * weight) + (1.85 * height) - (4.68 * age)));
                }
                textViewResult.setTextColor(Color.BLACK);
                textViewResult.setText(result + " kcal");
                Utils.hideKeyboard(this, findViewById(android.R.id.content));
            } else {
                textViewResult.setTextColor(Color.RED);
                textViewResult.setText("One of fields is empty");
                Utils.hideKeyboard(this, findViewById(android.R.id.content));
            }
        });
    }

    public void openHomeActivity(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}