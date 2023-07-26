package com.example.second;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class donate_sell_medicine_recycleview_adapter extends RecyclerView.Adapter<donate_sell_medicine_recycleview_adapter.MyViewHolder> {

    ArrayList<donate_sell_medicine_recycleview> list;
    Context context;

    public donate_sell_medicine_recycleview_adapter(Context context,ArrayList<donate_sell_medicine_recycleview> list) {
        this.list = list;
        this.context = context;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.donate_sell_medicine,parent,false);
        return new MyViewHolder(view);
    }


    public void onBindViewHolder(donate_sell_medicine_recycleview_adapter.MyViewHolder holder, int position) {
        donate_sell_medicine_recycleview dsmr = list.get(position);
        holder.medicine_name.setText(dsmr.getMedicine_name());
        holder.no_pills.setText(String.valueOf(dsmr.getNo_pills())+" pills");

    }


    public int getItemCount() {
        return list.size();
    }

    public void addItem(ArrayList<donate_sell_medicine_recycleview> arr){
        this.list = arr;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView medicine_name;
        private TextView no_pills;


        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            medicine_name = itemView.findViewById(R.id.medicine_name);
            no_pills = itemView.findViewById(R.id.no_pills);


        }

        @Override
        public void onClick(View view) {
            System.out.println("Clicked");
        }
    }
}
