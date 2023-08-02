package com.example.foodyghar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.foodyghar.frag.setting_frg;

public class TandC extends AppCompatActivity {

    Button btndecline,btnagree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tand_c);

        btndecline= findViewById(R.id.btndecline);
        btnagree= findViewById(R.id.btnagree);

        btnagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new setting_frg();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).addToBackStack("back").commit();
            }
        });

        btndecline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}