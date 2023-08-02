package com.example.foodyghar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Order_Details extends AppCompatActivity {
    TextView orderid,name,date,emailid,mobile,tablepay,foodpay;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
 /*       orderid=findViewById(R.id.order_id);
        name=findViewById(R.id.user_name);
        date=findViewById(R.id.pay_date);
        emailid=findViewById(R.id.user_email);
        mobile=findViewById(R.id.user_phone);
        tablepay=findViewById(R.id.table_payment);
        foodpay=findViewById(R.id.food_payment);

        SharedPreferences pref = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String Orderids = pref.getString("cart_id", null);
        String h_name = pref.getString("b_nslot", null);
        String bookdate = pref.getString("b_date", null);
        String email = pref.getString("b_eslot", null);
        String mob = pref.getString("contact", null);

        //String tablepay = pref.getString("b_date", null);
        *//*String Orderids = getIntent().getStringExtra("cart_id");
        String Username = getIntent().getStringExtra("uid");*//*
        *//*String Peackdate = getIntent().getStringExtra("b_date");
        String Emailid = getIntent().getStringExtra("emailid");
        String Mobile = getIntent().getStringExtra("contact");*//*
      *//*  String Tablepay = getIntent().getStringExtra("hotel_cost");
        String Foodpay = getIntent().getStringExtra("hotel_cost");*//*

        orderid.setText(Orderids);
        name.setText(h_name);
        date.setText(bookdate);
        emailid.setText(email);
        mobile.setText(mob);
        *//*tablepay.setText(Tablepay);
        foodpay.setText(Foodpay);**//*
*/
    }
}