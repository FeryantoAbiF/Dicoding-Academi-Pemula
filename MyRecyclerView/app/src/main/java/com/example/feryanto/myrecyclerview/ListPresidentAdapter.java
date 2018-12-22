package com.example.feryanto.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder> {

    private Context context;

    public ArrayList<President> getListPresidents() {
        return listPresident;
    }

    public void setListPesident(ArrayList<President> listPesident) {
        this.listPresident = listPesident;
    }

    private ArrayList<President> listPresident;

    public ListPresidentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_president, parent, false);

        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListPresidents().get(position).getName());
        holder.tvRemarks.setText(getListPresidents().get(position).getName());

        Glide.with(context)
                .load(getListPresidents().get(position).getPhoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPresidents().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(View itemView) {
            super(itemView);

            tvName= (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks= (TextView)itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto= (ImageView)itemView.findViewById(R.id.img_item_photo);
        }
    }
}
