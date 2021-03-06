package com.example.feryanto.myapplication;

import android.view.View;

class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private final OnItemClickCallback onItemClickCallback;
    public CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);
    }
    public interface OnItemClickCallback{
        void onItemClicked(View view, int position);
    }
}
