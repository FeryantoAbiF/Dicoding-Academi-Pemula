package com.example.feryanto.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_category;
    private ArrayList<President> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_category = findViewById(R.id.rv_category);
        rv_category.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(PresidentData.getListData());

        showRecyclerCardView();
    }

    private void showRecyclerCardView() {
        rv_category.setLayoutManager(new LinearLayoutManager(this));
        CardViewPresidentAdapter cardViewPresidentAdapter = new CardViewPresidentAdapter(this);
        cardViewPresidentAdapter.setListPresident(list);
        rv_category.setAdapter(cardViewPresidentAdapter);
    }
}
