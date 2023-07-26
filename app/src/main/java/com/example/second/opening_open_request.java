package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class opening_open_request extends AppCompatActivity {

    ImageView open_request_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }

        setContentView(R.layout.activity_opening_open_request);

        String user_type = getIntent().getStringExtra("user_type");

        open_request_back = findViewById(R.id.open_request_back);

        open_request_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user_type.equals("donor")) {
                    Intent intent = new Intent(opening_open_request.this, donor_patient.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("docotr")) {
                    Intent intent = new Intent(opening_open_request.this, doctor_fp.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("hospital")) {
                    Intent intent = new Intent(opening_open_request.this, hospital.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("compounder")) {
                    Intent intent = new Intent(opening_open_request.this, compounder.class);
                    finish();
                    startActivity(intent);
                }
                if(user_type.equals("pharma")) {
                    Intent intent = new Intent(opening_open_request.this, pharma.class);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }
}