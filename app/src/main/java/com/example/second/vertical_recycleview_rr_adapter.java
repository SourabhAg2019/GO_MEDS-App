package com.example.second;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class vertical_recycleview_rr_adapter extends RecyclerView.Adapter<vertical_recycleview_rr_adapter.MyViewHolder>{

    ArrayList<vertical_recycleview> list;


    public vertical_recycleview_rr_adapter( ArrayList<vertical_recycleview> list) {
        this.list = list;

    }

    public vertical_recycleview_rr_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raise_request_vertical_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(vertical_recycleview_rr_adapter.MyViewHolder holder, int position) {
        vertical_recycleview vrr = list.get(position);
        holder.address_vertical_rr.setText(vrr.getAddress_rr());
        holder.days_rr.setText(" "+vrr.getDays_ago()+"d ago ");
        if(vrr.getType().equals("Blood")==false)
            holder.blood_medicine_rr.setImageResource(R.drawable.drugs);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView address_vertical_rr ,days_rr;
        ImageView blood_medicine_rr , imageView3_rr ,imageView_rr ,imageView2_rr;

        public MyViewHolder(View itemView) {
            super(itemView);
            address_vertical_rr = itemView.findViewById(R.id.address_vertical_rr);
            blood_medicine_rr = itemView.findViewById(R.id.blood_medicine_rr);
            imageView3_rr = itemView.findViewById(R.id.imageView3_rr);
            imageView_rr = itemView.findViewById(R.id.imageView_rr);
            imageView2_rr = itemView.findViewById(R.id.imageView2_rr);
            days_rr = itemView.findViewById(R.id.days_rr);

        }

    }
}
