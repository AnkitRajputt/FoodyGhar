package com.example.foodyghar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Payment_successfully extends AppCompatActivity {
    TextView txt_bookid,txt_amount;
    String bookid,amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_successfully);
        txt_bookid=findViewById(R.id.txt_bookid);
        txt_amount=findViewById(R.id.txt_amount);

        SharedPreferences pref = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        bookid=pref.getString("b_id",null);
        amount=pref.getString("hotel_cost",null);


        txt_bookid.setText(bookid);
        txt_amount.setText(amount);


    }
}