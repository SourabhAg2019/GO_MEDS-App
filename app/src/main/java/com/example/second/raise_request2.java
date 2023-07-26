package com.example.second;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class raise_request2 extends AppCompatActivity {

    TabLayout tablayout;
    ViewPager viewpager;
    ImageView raise_request2_back;
    FloatingActionButton add_rr2_fb;
    Dialog dialog;
    TextView cancel_rr2_bt, add_rr2_bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }

        setContentView(R.layout.activity_raise_request2);

        String user_type = getIntent().getStringExtra("user_type");

        tablayout = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.viewPager);
        add_rr2_fb = findViewById(R.id.add_rr2_fb);

        tablayout.setupWithViewPager(viewpager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        vpAdapter.addFragment(new raise_request_fragment(), "RAISE REQUEST");
        vpAdapter.addFragment(new raise_request_fragment(), "REQUEST STATUS");

        viewpager.setAdapter(vpAdapter);

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                if(pos == 1)
                    add_rr2_fb.setVisibility(View.INVISIBLE);
                else
                    add_rr2_fb.setVisibility(View.VISIBLE);
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        raise_request2_back = findViewById(R.id.raise_request2_back);

        raise_request2_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_type.equals("donor"))
                {
                    Intent intent = new Intent(raise_request2.this,donor_patient.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("compounder"))
                {
                    Intent intent = new Intent(raise_request2.this,compounder.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("hospital"))
                {
                    Intent intent = new Intent(raise_request2.this,hospital.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("pharma"))
                {
                    Intent intent = new Intent(raise_request2.this,pharma.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("doctor"))
                {
                    Intent intent = new Intent(raise_request2.this,doctor_fp.class);
                    finish();
                    startActivity(intent);
                }
            }
        });

        add_rr2_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopUp(0);
            }
        });



    }

    private void createPopUp(int i) {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_rr2_pop_up);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.pop_up_bg));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        cancel_rr2_bt = dialog.findViewById(R.id.cancel_rr2_bt);
        dialog.show();

        cancel_rr2_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }

}