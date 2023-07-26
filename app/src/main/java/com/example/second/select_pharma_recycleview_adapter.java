package com.example.second;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class select_pharma_recycleview_adapter extends RecyclerView.Adapter<select_pharma_recycleview_adapter.MyViewHolder> {

    ArrayList<select_pharma_recycleview> list;
    select_pharma sp;

    public select_pharma_recycleview_adapter( select_pharma sp , ArrayList<select_pharma_recycleview> list) {
        this.list = list;
        this.sp = sp;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_pharma_recycleview,parent,false);
        return new MyViewHolder(view);
    }


    public void onBindViewHolder(select_pharma_recycleview_adapter.MyViewHolder holder, int position) {
        select_pharma_recycleview spr = list.get(position);
        holder.pharma_name.setText(spr.getPharma_name());
        holder.pharma_distance.setText(String.valueOf(spr.getDistance())+" km");

    }


    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView pharma_name;
        private TextView pharma_distance;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            pharma_name = itemView.findViewById(R.id.pharma_name);
            pharma_distance = itemView.findViewById(R.id.pharma_distance);


        }

        @Override
        public void onClick(View view) {
            System.out.println("Clicked");
            Intent intent = new Intent(sp,final_donate_sell.class);
            intent.putExtra("Type",sp.type);
            sp.startActivity(intent);
        }
    }
}
