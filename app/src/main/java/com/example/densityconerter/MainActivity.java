package com.example.densityconerter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final double densityConstant = 0.7;

    TextView textView1, textView2, displayText;
    EditText editTextDensity, editTextTemperature;
    Button calculate;
    double temperatureOf15 = 15;
    int backButtonPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //writing the superscripts of the units
        textView1 = findViewById(R.id.textView1);
        textView1.setText(Html.fromHtml("Observed Density "+getString(R.string.observed_density)));

        textView2 = findViewById(R.id.textView2);
        textView2.setText(Html.fromHtml("Observed Temperature "+ getString(R.string.observed_temperature)));

        editTextDensity = findViewById(R.id.editTextDensity);
        editTextTemperature = findViewById(R.id.editTextTemperature);



        displayText = findViewById(R.id.textView3);
        calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               double inputDensity = Double.parseDouble(editTextDensity.getText().toString());
               double inputTemperature = Double.parseDouble(editTextTemperature.getText().toString());

               double densityAt15 = inputDensity + densityConstant *(inputTemperature - temperatureOf15);


               displayText.setText(Html.fromHtml("density@15"+ getString(R.string.observed_temperature) + "=" + densityAt15));

           }
       });

    }

    @Override
    public void onBackPressed() {
        if (backButtonPressed >= 1){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "press again to exist", Toast.LENGTH_LONG).show();
        }
        //super.onBackPressed();
        backButtonPressed++;
    }

  
}
