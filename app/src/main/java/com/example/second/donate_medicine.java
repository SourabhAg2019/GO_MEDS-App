package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class donate_medicine extends AppCompatActivity {

    TextView add_medicine_next , pop_cancel , donate_medicine_title;
    ImageView donate_medicine_back;
    FloatingActionButton add_med_fb;
    Dialog dialog;
    private AlertDialog.Builder dialogueBox_builder;
    private AlertDialog adialog;

    RecyclerView recycleview_donate_medicine;
    donate_sell_medicine_recycleview_adapter dsmra;
    ArrayList<donate_sell_medicine_recycleview> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        setContentView(R.layout.activity_donate_medicine);

        String type = getIntent().getStringExtra("Type");
        if(type.equals("1"))
        {
            donate_medicine_title = findViewById(R.id.donate_medicine_title);
            donate_medicine_title.setText("Sell Medicine");
        }


        arr = new ArrayList<>();
        arr.add(new donate_sell_medicine_recycleview("Nici Plus",7,0));
        arr.add(new donate_sell_medicine_recycleview("Sinarest",6,0));
        arr.add(new donate_sell_medicine_recycleview("NICIP",4,10));
        arr.add(new donate_sell_medicine_recycleview("Disprine",2,0));
        arr.add(new donate_sell_medicine_recycleview("Pentab40",5,18));

        recycleview_donate_medicine = findViewById(R.id.recycleview_donate_medicine);
        recycleview_donate_medicine.setHasFixedSize(true);
        recycleview_donate_medicine.setLayoutManager(new LinearLayoutManager(this));

        dsmra = new donate_sell_medicine_recycleview_adapter(donate_medicine.this,arr);
        recycleview_donate_medicine.setAdapter(dsmra);

        add_medicine_next = findViewById(R.id.add_medicine_next);
        donate_medicine_back = findViewById(R.id.donate_medicine_back);
        add_med_fb = findViewById(R.id.add_med_fb);




        add_medicine_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(donate_medicine.this,select_pharma.class);
                if(type.equals("1"))
                    intent.putExtra("Type",Integer.toString(1));
                else
                    intent.putExtra("Type",Integer.toString(0));
                finish();
                startActivity(intent);
            }
        });

        donate_medicine_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(donate_medicine.this,donor_patient.class);
                finish();
                startActivity(intent);
            }
        });

        add_med_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopUp(0);
            }
        });

    }

    private void createPopUp(int i) {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_medicine_pop_up);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_bg));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        pop_cancel = dialog.findViewById(R.id.cancel_medicine_bt);
        dialog.show();

        pop_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}