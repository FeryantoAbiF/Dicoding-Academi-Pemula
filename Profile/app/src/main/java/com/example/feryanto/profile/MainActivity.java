package com.example.feryanto.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView w;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        w = findViewById(R.id.w);
        w.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent w = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(w);
            }
        });
    }

}
