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

public class doctor_fp extends AppCompatActivity {

    ImageView  profile_image_doctor, ask_for_help;
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

        setContentView(R.layout.activity_doctor_fp);

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


        profile_image_doctor = findViewById(R.id.profile_image_doctor);
        ask_for_help = findViewById(R.id.ask_for_help);

        orra = new open_request_recycleview_adapter(doctor_fp.this,arr);
        recycleview_donor_patient.setAdapter(orra);




        profile_image_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doctor_fp.this,all_profile.class);
                intent.putExtra("user_type","doctor");
                finish();
                startActivity(intent);
            }
        });

        ask_for_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(doctor_fp.this,raise_request2.class);
                intent.putExtra("user_type","doctor");
                finish();
                startActivity(intent);
            }
        });


    }
}