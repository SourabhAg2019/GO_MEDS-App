package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class sign_up extends AppCompatActivity {


    Animation ct0;
    LinearLayout logo_text3;
    TextView already_acc;
    //TextView lic_no;
    TextInputLayout spin;
    AutoCompleteTextView autocomp2;
    ArrayList<String> user_type;
    ArrayAdapter <String> arrayAdapter_user_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //handling Notch and doing it Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        setContentView(R.layout.activity_sign_up);


        user_type = new ArrayList<>();
        user_type.add("Donor / Patient");
        user_type.add("Compounder");
        user_type.add("Hospital");
        user_type.add("Pharmacist");
        user_type.add("Doctor");

        arrayAdapter_user_type = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item,user_type);
        ct0 = AnimationUtils.loadAnimation(this,R.anim.ct0);
        logo_text3 = findViewById(R.id.logo_text3);
        //lic_no = findViewById(R.id.lic_no);
        spin = (TextInputLayout) findViewById(R.id.spin);
        autocomp2 = (AutoCompleteTextView) findViewById(R.id.autocomp2);
        already_acc = findViewById(R.id.already_acc);
        logo_text3.setAnimation(ct0);

        autocomp2.setAdapter(arrayAdapter_user_type);
        //autocomp2.setThreshold(1);


        already_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sign_up.this,login.class);
                finish();
                startActivity(intent);
            }
        });

    }
}