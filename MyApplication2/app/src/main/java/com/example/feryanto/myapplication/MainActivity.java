package com.example.feryanto.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnbiodata;
    private Button btntentangapp;
    private Button btncontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnbiodata = (Button)findViewById(R.id.btn_biodata);
        btnbiodata.setOnClickListener(this);
        btntentangapp = (Button)findViewById(R.id.btn_tentangapp);
        btntentangapp.setOnClickListener(this);
        btncontact = (Button)findViewById(R.id.btn_contact_us);
        btncontact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_biodata:
                Intent moveIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(moveIntent);
            break;
            case R.id.btn_tentangapp:
                Intent moveWithDataIntent= new Intent(MainActivity.this, Main3Activity.class);
                moveWithDataIntent.putExtra(Main3Activity.Tentang, "Merupakan Sebuah Aplikasi Sederhana");
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_contact_us:
                String phonenumber= "089675988338";
                Intent dialnumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+phonenumber));
                startActivity(dialnumber);
                break;

        }
    }
}
