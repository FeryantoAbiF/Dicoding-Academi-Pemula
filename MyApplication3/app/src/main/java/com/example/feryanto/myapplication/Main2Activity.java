package com.example.feryanto.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView hasilconvert, satuanpilihan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        hasilconvert = findViewById(R.id.hasil_convert);
        satuanpilihan = findViewById(R.id.satuan_pilihan);

        Intent intent = getIntent();

        hasilconvert.setText(intent.getStringExtra("HASIL_CONVERT"));
        satuanpilihan.setText(intent.getStringExtra("SATUAN_PILIHAN"));
    }
}
