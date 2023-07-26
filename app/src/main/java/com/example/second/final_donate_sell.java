package com.example.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class final_donate_sell extends AppCompatActivity {

    ImageView final_donate_sell_back;
    TextView donate_sell_book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }

        setContentView(R.layout.activity_final_donate_sell);

        String type = getIntent().getStringExtra("Type");
        if(type.equals("1"))
        {
            donate_sell_book = findViewById(R.id.donate_sell_book);
            donate_sell_book.setText("Sell");
        }

        final_donate_sell_back = findViewById(R.id.final_donate_sell_back);

        final_donate_sell_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(final_donate_sell.this,select_pharma.class);
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