package com.example.exercise_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText heightET;
    private EditText massET;
    private Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heightET = findViewById(R.id.et_height);
        massET = findViewById(R.id.et_mass);
        calculateBtn = findViewById(R.id.btn_calculate);
    }
    public void calculateBMI(View view) {
        String height = heightET.getText().toString().trim();
        String mass = massET.getText().toString().trim();
        if (height.isEmpty() && mass.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter values to continue", Toast.LENGTH_LONG).show();
        } else{
            Double heightValue = Double.parseDouble(height);
            Double massValue = Double.parseDouble(mass);
            Double bmiValue = massValue / (heightValue * heightValue);

            String bmiStringValu = Double.toString(bmiValue);;
            // Create the Intent object of this class Context() to Second_activity class
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            // now by putExtra method put the value in key, value pair key is
            // message_key by this key we will receive the value, and put the string
            intent.putExtra("bmiValue", bmiStringValu);
            // start the Intent
            startActivity(intent);

        }
    }
}