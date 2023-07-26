package com.example.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;

public class donor_patient extends AppCompatActivity {

    ImageView donate_medicine1 , sell_medicine1 , profile_image_donor, ask_for_help;
    RecyclerView recycleview_donor_patient;
    open_request_recycleview_adapter orra;
    ArrayList<open_request_recycleview> arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }

        setContentView(R.layout.activity_donor_patient);

        arr = new ArrayList<>();
        arr.add(new open_request_recycleview("Harshit",2,"Blood"));
        arr.add(new open_request_recycleview("Sorab",0,"Blood"));
        arr.add(new open_request_recycleview("Gokul",5,"Medicine"));
        arr.add(new open_request_recycleview("Ayush",6,"Blood"));
        arr.add(new open_request_recycleview("Tanmay",3,"Blood"));
        arr.add(new open_request_recycleview("Avik",1,"Medicine"));
        arr.add(new open_request_recycleview("Bharavi",4,"Blood"));

        recycleview_donor_patient = findViewById(R.id.recycleview_donor_patient);
        recycleview_donor_patient.setHasFixedSize(true);
        recycleview_donor_patient.setLayoutManager(new LinearLayoutManager(this));

        donate_medicine1 = findViewById(R.id.donate_medicine1);
        sell_medicine1 = findViewById(R.id.sell_medicine1);
        profile_image_donor = findViewById(R.id.profile_image_donor);
        ask_for_help = findViewById(R.id.ask_for_help);

        orra = new open_request_recycleview_adapter(donor_patient.this,arr);
        recycleview_donor_patient.setAdapter(orra);


        donate_medicine1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(donor_patient.this,donate_medicine.class);
                intent.putExtra("Type",Integer.toString(0));
                finish();
                startActivity(intent);
            }
        });

        sell_medicine1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(donor_patient.this,donate_medicine.class);
                intent.putExtra("Type",Integer.toString(1));
                finish();
                startActivity(intent);
            }
        });

        profile_image_donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(donor_patient.this,all_profile.class);
                intent.putExtra("user_type","donor");
                finish();
                startActivity(intent);
            }
        });

        ask_for_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(donor_patient.this,raise_request2.class);
                intent.putExtra("user_type","donor");
                finish();
                startActivity(intent);
            }
        });



    }
}