package com.example.feryanto.kontak;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView telp = findViewById(R.id.telp);
        telp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    case R.id.telp:
                        String phonenumber = "082295103327";
                        Intent dialnumber = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + phonenumber));
                        startActivity(dialnumber);
                        break;
                }
            }
        });
        ImageView website = findViewById(R.id.web);
        website.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.web:
                        Uri webpage = Uri.parse("http://www.android.com");
                        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                        startActivity(webIntent);
                    break;
                }
            }
        });
        ImageView facebook = findViewById(R.id.fb);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.fb:
                        Uri fbpage = Uri.parse("https://www.facebook.com/SMAN-14-Bandung-339617946099977/");
                        Intent fbIntent = new Intent(Intent.ACTION_VIEW, fbpage);
                        startActivity(fbIntent);
                    break;
                }

            }
        });
        ImageView whatsapp = findViewById(R.id.wa);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.wa:
                        String number = "+6282295103327";
                        String url = "https://api.whatsapp.com/send?phone="+number;
                        Intent whatsapp = new Intent(Intent.ACTION_VIEW);
                        whatsapp.setData(Uri.parse(url));
                        startActivity(whatsapp);
                    break;
                }
            }
        });
        ImageView instagram = findViewById(R.id.ig);
        instagram.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.DONUT)
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.ig:
                        Uri ig = Uri.parse("http://instagram.cm/_u/fryantabif");
                        Intent likeIng = new Intent(Intent.ACTION_VIEW, ig);
                        likeIng.setPackage("com.instagram.android");
                        try {
                            startActivity(likeIng);
                        }
                        catch (ActivityNotFoundException e){
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://instagram.com/fryantabif")));
                        }
                    break;
                }

            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.beranda) {
            // Handle the camera action
        } else if (id == R.id.profil) {

        } else if (id == R.id.kalender) {

        } else if (id == R.id.kontak) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
