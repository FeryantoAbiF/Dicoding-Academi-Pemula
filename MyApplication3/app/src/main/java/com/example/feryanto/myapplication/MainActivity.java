package com.example.feryanto.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText inputsuhu;
    Button convert;
    RadioButton reamur, farenheit, kelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputsuhu = findViewById(R.id.input_suhu);
        reamur = findViewById(R.id.reamur);
        farenheit = findViewById(R.id.farenheit);
        kelvin = findViewById(R.id.kelvin);
        convert = findViewById(R.id.convert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double input = Double.parseDouble(inputsuhu.getText().toString());
                    double output = 0;
                    String satuan = "";

                    if (reamur.isChecked()) {
                        output = (4d / 5d) * input;
                        satuan = "Reamur";
                    } else if (farenheit.isChecked()) {
                        output = ((9d / 5d) * input) + 32;
                        satuan = "Farenheit";

                    } else if (kelvin.isChecked()) {
                        output = input + 273;
                        satuan = "Kelvin";
                    }

                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("HASIL_CONVERT", String.valueOf(output));
                    intent.putExtra("SATUAN_PILIHAN", satuan);
                    startActivity(intent);

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Masukan Suhu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
