package com.example.feryanto.barvolume;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener {
    private android.widget.EditText edt_panjang, edt_lebar, edt_tinggi;
    private android.widget.Button btn_hitung;
    private android.widget.TextView tv_hasil;
    private static final String STATE_HASIL = "state_hasil";

    protected void onSaveInstanceState(Bundle outState){
        outState.putString(STATE_HASIL, tv_hasil.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_panjang=(android.widget.EditText)findViewById(R.id.edt_panjang);
        edt_lebar=(android.widget.EditText)findViewById(R.id.edt_lebar);
        edt_tinggi=(android.widget.EditText)findViewById(R.id.edt_tinggi);
        btn_hitung=(android.widget.Button)findViewById(R.id.btn_hitung);
        tv_hasil=(android.widget.TextView)findViewById(R.id.tv_hasil);
        btn_hitung.setOnClickListener(this);

        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tv_hasil.setText(hasil);
        }

    }

    public void onClick(android.view.View v){
    if (v.getId()== R.id.btn_hitung){
        String panjang= edt_panjang.getText().toString().trim();
        String lebar= edt_lebar.getText().toString().trim();
        String tinggi= edt_tinggi.getText().toString().trim();
        boolean isEmptyFields = false;

        if(android.text.TextUtils.isEmpty(panjang)){
            isEmptyFields = true;
            edt_panjang.setError("Field ini tidak boleh kosong");
        }
        if(android.text.TextUtils.isEmpty(lebar)){
            isEmptyFields = true;
            edt_lebar.setError("Field ini tidak boleh kosong");
        }
        if(android.text.TextUtils.isEmpty(tinggi)){
            isEmptyFields = true;
            edt_tinggi.setError("Field ini tidak boleh kosong");
        }
        if(!isEmptyFields){
            double p = Double.parseDouble(panjang);
            double l = Double.parseDouble(lebar);
            double t = Double.parseDouble(tinggi);
            double volume = p * l * t;
            tv_hasil.setText(String.valueOf(volume));
        }

        }
    }


}
