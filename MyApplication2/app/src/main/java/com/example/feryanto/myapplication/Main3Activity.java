package com.example.feryanto.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    public static String Tentang="tentang";

    private TextView datareceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        datareceived= (TextView)findViewById(R.id.data_received);
        String tentang = getIntent().getStringExtra(Tentang);
        String text="Tentang : "+tentang;
        datareceived.setText(text);
    }
}
