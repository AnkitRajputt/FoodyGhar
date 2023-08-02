package com.example.foodyghar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.foodyghar.Model.Paymentdetail;

import java.util.ArrayList;

public class Payment_successfully_menu extends AppCompatActivity {
    TextView txt_preorderbookid,txt_preorderamount;
    String preorderbookid,preorderamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_successfully_menu);

        txt_preorderbookid=findViewById(R.id.txt_preorderbookid);
        txt_preorderamount=findViewById(R.id.txt_preorderamount);

        SharedPreferences pref = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        preorderbookid=pref.getString("cart_id",null);
        preorderamount=pref.getString("menuprice",null);


        txt_preorderbookid.setText(preorderbookid);
        txt_preorderamount.setText(preorderamount);





    }
}