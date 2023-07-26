package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class login extends AppCompatActivity {

    Animation ct0,ct,top_down;
    LinearLayout logo_text2;
    Button sign_compunder;
    TextInputLayout password;
    ImageView logo_image2;
    View view2;
    TextView forget_pass, new_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //handling Notch and doing it Fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
        setContentView(R.layout.activity_login);

        ct0 = AnimationUtils.loadAnimation(this,R.anim.ct0);
        ct = AnimationUtils.loadAnimation(this,R.anim.ct);
        top_down = AnimationUtils.loadAnimation(this,R.anim.top_down);
        logo_text2 = findViewById(R.id.logo_text2);
        new_user = findViewById(R.id.new_user);
        logo_image2 = findViewById(R.id.logo_image2);
        forget_pass = findViewById(R.id.foreget_pass);
        password = findViewById(R.id.password);
        //sign_compunder = findViewById(R.id.sign_compounder);
        view2 = findViewById(R.id.view2);

        view2.setAnimation(top_down);
        logo_text2.setAnimation(ct0);
        logo_image2.setAnimation(ct);

        new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,sign_up.class);
                finish();
                startActivity(intent);
            }
        });

        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this,forget_password.class);
                finish();
                startActivity(intent);
            }
        });

//        sign_compunder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(login.this,login_compounder.class);
//                finish();
//                startActivity(intent);
//            }
//        });

    }

    public void logiin(View view)
    {
        String pass = password.getEditText().getText().toString();

        if(pass.equals("1"))
        {
            Intent intent = new Intent(login.this,donor_patient.class);
            finish();
            startActivity(intent);
        }
        if(pass.equals("2"))
        {
            Intent intent = new Intent(login.this,compounder.class);
            finish();
            startActivity(intent);
        }
        if(pass.equals("3"))
        {
            Intent intent = new Intent(login.this,hospital.class);
            finish();
            startActivity(intent);
        }
        if(pass.equals("4"))
        {
            Intent intent = new Intent(login.this,pharma.class);
            finish();
            startActivity(intent);
        }
        if(pass.equals("5"))
        {
            Intent intent = new Intent(login.this,doctor_fp.class);
            finish();
            startActivity(intent);
        }
    }
}