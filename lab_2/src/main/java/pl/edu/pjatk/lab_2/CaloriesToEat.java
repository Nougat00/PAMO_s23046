package pl.edu.pjatk.lab_2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CaloriesToEat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calories_to_eat);
        EditText editTextHeight = findViewById(R.id.height);
        EditText editTextWeight = findViewById(R.id.weight);
        EditText editTextAge = findViewById(R.id.age);
        RadioButton radioButtonMale = findViewById(R.id.male);
        RadioButton radioButtonFemale = findViewById(R.id.female);
        Button buttonSubmit = findViewById(R.id.submit);
        TextView textViewResult = findViewById(R.id.result);


        buttonSubmit.setOnClickListener(v -> {
            if (!radioButtonMale.isChecked() && !radioButtonFemale.isChecked()){
                textViewResult.setText("No gender has been selected");
            }
            float height = Float.parseFloat(editTextHeight.getText().toString());
            float weight = Float.parseFloat(editTextWeight.getText().toString());
            float age = Float.parseFloat(editTextAge.getText().toString());
            float result;
            if (radioButtonMale.isChecked()) {
                result = (float) (66.47 + (13.7 * weight) + (5.0 * height) - (6.76 * age));
            } else {
                result = (float) (655.1 + (9.567 * weight) + (1.85 * height) - (4.68 * age));
            }
            hideKeyboard();
            textViewResult.setText(result + " kcal");
        });
    }

    private void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}