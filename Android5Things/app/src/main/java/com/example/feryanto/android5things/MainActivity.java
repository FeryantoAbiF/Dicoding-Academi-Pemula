package com.example.feryanto.android5things;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView sofa;
    ImageView camera;
    ImageView satria;
    ImageView rezer;
    ImageView ml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sofa    = (ImageView) findViewById (R.id.imageView);
        camera  = (ImageView) findViewById (R.id.imageView2);
        satria  = (ImageView) findViewById (R.id.imageView3);
        rezer   = (ImageView) findViewById (R.id.imageView4);
        ml      = (ImageView) findViewById (R.id.imageView5);

        sofa.setOnClickListener( new View.OnClickListener(){

            public void onClick(View view){

                Intent sofa= new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(sofa);
            }
        });

        camera.setOnClickListener( new View.OnClickListener(){

            public void onClick(View view){

                Intent camera= new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(camera);
            }
        });

        satria.setOnClickListener( new View.OnClickListener(){

            public void onClick(View view){

                Intent satria= new Intent(getApplicationContext(), Main4Activity.class);
                startActivity(satria);
            }
        });

        rezer.setOnClickListener( new View.OnClickListener(){

            public void onClick(View view){

                Intent rezer= new Intent(getApplicationContext(), Main5Activity.class);
                startActivity(rezer);
            }
        });

        ml.setOnClickListener( new View.OnClickListener(){

            public void onClick(View view){

                Intent ml= new Intent(getApplicationContext(), Main6Activity.class);
                startActivity(ml);
            }
        });
    }
}
