package com.example.feryanto.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        President presidentditerima = getIntent().getParcelableExtra("key");

        ImageView gambar = findViewById(R.id.img_item_photo);
        TextView name = findViewById(R.id.tv_item_name);
        TextView remarks = findViewById(R.id.tv_item_remarks);
        TextView deskripsi = findViewById(R.id.deskripsi);
        TextView lahir = findViewById(R.id.content_lahir);
        TextView wafat = findViewById(R.id.content_wafat);

        Glide.with(this)
                .load(presidentditerima.getPhoto())
                .override(350, 550)
                .into(gambar);
        name.setText(presidentditerima.getName());
        remarks.setText(presidentditerima.getRemarks());
        deskripsi.setText(presidentditerima.getDeskripsi());
        lahir.setText(presidentditerima.getLahir());
        wafat.setText(presidentditerima.getWafat());

        Log.i("photo", presidentditerima.getPhoto());
        Log.i("deskripsi", presidentditerima.getDeskripsi());
    }

}
