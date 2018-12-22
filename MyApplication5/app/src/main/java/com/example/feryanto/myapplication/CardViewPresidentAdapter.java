package com.example.feryanto.myapplication;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
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

class CardViewPresidentAdapter extends RecyclerView.Adapter<CardViewPresidentAdapter.CardViewHolder> {
    private ArrayList<President> listPresident;
    private Context context;

    public CardViewPresidentAdapter(Context context){
        this.context = context;
    }

    public ArrayList<President> getListPresident(){
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident){
        this.listPresident = listPresident;
    }

    @NonNull
    @Override
    public CardViewPresidentAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_president, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        final President  p = getListPresident().get(position);

        Glide.with(context).load(p.getPhoto()).override(350,550).into(holder.imgPhoto);
        holder.tvname.setText(p.getName());
        holder.tvremarks.setText(p.getRemarks());
        holder.president = p;

        holder.btnsahre.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imgPhoto;
        TextView tvname, tvremarks;
        Button btndetail, btnsahre;
        President president;

        public CardViewHolder(View view) {
            super(view);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvname = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvremarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnsahre = (Button)itemView.findViewById(R.id.btn_set_share);
            btndetail = (Button)itemView.findViewById(R.id.btn_set_detail);
            btndetail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
