package com.example.feryanto.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardViewPresidentAdapter extends RecyclerView.Adapter<CardViewPresidentAdapter.CardViewHolder> {

    private ArrayList<President> listPresident;
    private Context context;
    private Activity activity;


    public CardViewPresidentAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        final President p = getListPresident().get(position);

        Glide.with(context)
                .load(p.getPhoto())
                .override(340, 550)
                .into(holder.imgPhoto);

        holder.tvName.setText(p.getName());
        holder.tvRemarks.setText(p.getRemarks());
        holder.president = p;

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " + getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    public void startactivity(Intent intent) {

    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnDetail, btnShare;
        President president;

        public CardViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnShare = itemView.findViewById(R.id.btn_set_share);
            btnDetail = itemView.findViewById(R.id.btn_set_detail);
            btnDetail.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("key", president);
            context.startActivity(intent);
        }
    }
}

