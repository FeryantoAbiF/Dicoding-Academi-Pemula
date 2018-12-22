package com.example.feryanto.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_Category;
    private ArrayList<President> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_Category = findViewById(R.id.rv_category);


        list = new ArrayList<>();
        list.addAll(PresidentData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList() {
        rv_Category.setLayoutManager(new LinearLayoutManager(this));
        ListPresidentAdapter listPresidentAdapter = new ListPresidentAdapter(this);
        listPresidentAdapter.setListPesident(list);
        rv_Category.setAdapter(listPresidentAdapter);
    }

    private void showRecyclerGrid() {
        rv_Category.setLayoutManager(new LinearLayoutManager(this));
        GridPresidentAdapter gridPresidentAdapter = new GridPresidentAdapter(this);
        gridPresidentAdapter.setListPresident(list);
        rv_Category.setAdapter(gridPresidentAdapter);
    }

    private void showRecyclerCardView() {
        rv_Category.setLayoutManager(new LinearLayoutManager(this));
        CardViewPresidentAdapter cardViewPresidentAdapter = new CardViewPresidentAdapter(this);
        cardViewPresidentAdapter.setListPresident(list);
        rv_Category.setAdapter(cardViewPresidentAdapter);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        String title = null;
        switch (item.getItemId()) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        setActionBarTitle(title);
        return super.onOptionsItemSelected(item);
    }
}


