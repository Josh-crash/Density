package com.example.densityconerter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final double densityConstant = 4.5;

    TextView textView1, textView2, textView3;
    EditText editTextDensity, editTextTemperature;
    Button calculate;
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
        double inputDensity = Double.parseDouble(editTextDensity.toString());


            Log.d("myTag", "this is densty " + inputDensity);



        editTextTemperature = findViewById(R.id.editTextTemperature);
        double inputTemperature = Double.parseDouble(editTextTemperature.toString());




    }
}
