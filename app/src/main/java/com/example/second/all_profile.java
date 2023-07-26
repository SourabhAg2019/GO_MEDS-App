package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class all_profile extends AppCompatActivity {

    ListView profile_listView;
    ImageView profile_back,logout;
    ArrayList<String> profile_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }

        setContentView(R.layout.activity_all_profile);


        profile_list = new ArrayList<>();
        String user_type = getIntent().getStringExtra("user_type");

        String donor_items[] = {"My Profile","Track History","Scan QR Code","Reedem Points","Booked Medicine","Notification","Log out"};
        String doctor_items[] = {"My Profile","Track History","Scan QR Code","Notification","Log out"};
        String hospital_items[] = {"My Profile","Track History","Scan QR Code","Notification","Log out"};
        String compounder_items[] = {"My Profile","Track History","Scan QR Code","Notification","Log out"};
        String pharma_items[] = {"My Profile","Track History","Scan QR Code","Booked Medicine","Notification","Log out"};


        if(user_type.equals("donor")) {
            for (int i = 0; i < donor_items.length; i++)
                profile_list.add(donor_items[i]);
        }

        if(user_type.equals("doctor")) {
            for (int i = 0; i < doctor_items.length; i++)
                profile_list.add(doctor_items[i]);
        }

        if(user_type.equals("hospital")) {
            for (int i = 0; i < hospital_items.length; i++)
                profile_list.add(hospital_items[i]);
        }

        if(user_type.equals("compounder")) {
            for (int i = 0; i < compounder_items.length; i++)
                profile_list.add(compounder_items[i]);
        }

        if(user_type.equals("pharma")) {
            for (int i = 0; i < pharma_items.length; i++)
                profile_list.add(pharma_items[i]);
        }

        profile_back = findViewById(R.id.profile_back);
        profile_listView = findViewById(R.id.profile_listView);
        logout = findViewById(R.id.logout);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,profile_list);
        profile_listView.setAdapter(arrayAdapter);

        profile_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected_item = adapterView.getItemAtPosition(i).toString();
                if(selected_item=="My Profile")
                {
                    Intent intent = new Intent(all_profile.this,my_profile.class);
                    finish();
                    startActivity(intent);
                }
                if(selected_item=="Track History"){}
                if(selected_item=="Scan QR Code"){}
                if(selected_item=="Reedem Points"){}
                if(selected_item=="Notification"){}
                if(selected_item=="Log out")
                {
                    Intent intent = new Intent(all_profile.this,login.class);
                    finish();
                    startActivity(intent);
                }

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(all_profile.this,login.class);
                finish();
                startActivity(intent);
            }
        });




        profile_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_type.equals("donor"))
                {
                    Intent intent = new Intent(all_profile.this,donor_patient.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("compounder"))
                {
                    Intent intent = new Intent(all_profile.this,compounder.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("hospital"))
                {
                    Intent intent = new Intent(all_profile.this,hospital.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("pharma"))
                {
                    Intent intent = new Intent(all_profile.this,pharma.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("doctor"))
                {
                    Intent intent = new Intent(all_profile.this,doctor_fp.class);
                    finish();
                    startActivity(intent);
                }
            }
        });


    }
}