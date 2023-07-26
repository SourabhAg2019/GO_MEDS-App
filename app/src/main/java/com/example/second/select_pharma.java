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

public class select_pharma extends AppCompatActivity {

    ImageView select_pharma_back;

    RecyclerView recycleview_select_pharma;
    select_pharma_recycleview_adapter spra;
    ArrayList<select_pharma_recycleview> arr;

    public String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        setContentView(R.layout.activity_select_pharma);

        type = getIntent().getStringExtra("Type");


        arr = new ArrayList<>();
        arr.add(new select_pharma_recycleview("Harshit Medicos",2));
        arr.add(new select_pharma_recycleview("Sorab Medicos",2));
        arr.add(new select_pharma_recycleview("Ayush Medicos",1));

        recycleview_select_pharma = findViewById(R.id.recycleview_select_pharma);
        recycleview_select_pharma.setHasFixedSize(true);
        recycleview_select_pharma.setLayoutManager(new LinearLayoutManager(this));

        spra = new select_pharma_recycleview_adapter(select_pharma.this,arr);
        recycleview_select_pharma.setAdapter(spra);

        select_pharma_back = findViewById(R.id.select_pharma_back);

        select_pharma_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(select_pharma.this,donate_medicine.class);
                if(type.equals("1"))
                    intent.putExtra("Type",Integer.toString(1));
                else
                    intent.putExtra("Type",Integer.toString(0));
                finish();
                startActivity(intent);
            }
        });

    }
}