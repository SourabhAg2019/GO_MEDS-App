package com.example.second;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class open_request_recycleview_adapter extends RecyclerView.Adapter<open_request_recycleview_adapter.MyViewHolder> {
    ArrayList<open_request_recycleview> list;
    Context context;

    public open_request_recycleview_adapter(Context context, ArrayList<open_request_recycleview> list) {
        this.list = list;
        this.context = context;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.open_request,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(open_request_recycleview_adapter.MyViewHolder holder, int position) {
        open_request_recycleview orr = list.get(position);
        holder.request_profile.setText(" Request by "+orr.getRequest_profile_name());
        holder.days.setText(" "+orr.getDays_ago()+"d ago ");
        if(orr.getType().equals("Blood")==false)
            holder.blood_medicine.setImageResource(R.drawable.drugs);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(ArrayList<open_request_recycleview> arr){
        this.list = arr;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView profile_imageview;
        private ImageView blood_medicine;
        private TextView request_profile;
        private TextView days;
        private TextView textView10;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            profile_imageview = itemView.findViewById(R.id.profile_imageView);
            blood_medicine = itemView.findViewById(R.id.blood_medicine);
            request_profile = itemView.findViewById(R.id.request_profile);
            days = itemView.findViewById(R.id.days);
            textView10 = itemView.findViewById(R.id.textView10);
        }

        @Override
        public void onClick(View view) {
            System.out.println("Clicked");
            Intent intent = new Intent(context,opening_open_request.class);
            String user_type = context.getClass().getSimpleName();
            if(user_type.equals("donor_patient"))
                user_type = "donor";
            if(user_type.equals("doctor_fp"))
                user_type = "doctor";
            intent.putExtra("user_type",user_type);
            context.startActivity(intent);
        }
    }

}
