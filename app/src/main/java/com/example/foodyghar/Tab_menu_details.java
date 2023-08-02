package com.example.foodyghar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.foodyghar.Model.Resultcarttable;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tab_menu_details extends AppCompatActivity {

    ImageView foodimg, sharefood, back_page_menu_details,history;
    ElegantNumberButton quantity_btn;
    TextView foodname;
    TextView foodprice, btn_atc;
    ReadMoreTextView decfood;
    String foodid;


    //  ArrayList<Carttable> carttableArrayList;
    int number;
    Homepage homepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_menu_details);
        btn_atc = findViewById(R.id.btn_atc);
        foodimg = findViewById(R.id.imageView8);
        foodname = findViewById(R.id.FoodName);
        foodprice = findViewById(R.id.FoodPrice);
        decfood = findViewById(R.id.descfood);
        quantity_btn = findViewById(R.id.quantity_btn);
        sharefood = findViewById(R.id.sharefood);
        back_page_menu_details = findViewById(R.id.back_page_menu_details);
        history = findViewById(R.id.history);



        foodid = getIntent().getStringExtra("FoodId");
        Toast.makeText(this, "FoodId" + foodid, Toast.LENGTH_SHORT).show();
        Log.e("Error", String.valueOf(foodid));
        String fname = getIntent().getStringExtra("FoodName");
        String fpeice = getIntent().getStringExtra("FoodPrice");
        String fimg = getIntent().getStringExtra("FoodImg");

        Picasso.get().load(fimg).resize(600, 500).into(foodimg);
        foodname.setText(fname);
        foodprice.setText(fpeice);
        //quantity_btn.setNumber(fqun);
        //decfood.setText(fdesc);

        quantity_btn.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                //foodprice.setText(String.valueOf(newValue * Integer.parseInt(fpeice)));
                foodprice.setText("₹ " + String.valueOf(newValue * Integer.parseInt(fpeice)));
                number = newValue;
            }
        });

        back_page_menu_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        sharefood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String sharebody = "Checkout this Food";
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, sharebody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });


        btn_atc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Tab_menu_details.this, "Added Please wait..", Toast.LENGTH_SHORT).show();

                SharedPreferences sharedPreferences = getSharedPreferences("mypref", Context.MODE_PRIVATE);
                String uid = sharedPreferences.getString("uid", null);
                Log.e("Arraylistsize", uid);
                String resid = sharedPreferences.getString("hotel_id", null);
                Log.e("Arraylistsize", resid);
                int temp = 0, i;

                String t = String.valueOf(number);
                Log.e("TOTALITEM", (uid + ":" + foodid + ":" + t));
                if (temp == 0) {
                    String totalitem = String.valueOf(number);
                    APInterface apInterface = APIClient.getClient().create(APInterface.class);
                    Call<Resultcarttable> resultcarttableCall1 = apInterface.addtocart(uid, foodid, resid, totalitem);
                    Log.e("TOTALITEM", (uid + ":" + foodid + ":" + t));
                    resultcarttableCall1.enqueue(new Callback<Resultcarttable>() {
                        @Override
                        public void onResponse(Call<Resultcarttable> call, Response<Resultcarttable> response) {
                            Intent intent = new Intent(Tab_menu_details.this, Tab_Menu_AddtoCart.class);
                            startActivity(intent);
                            Toast.makeText(Tab_menu_details.this, "cart added ", Toast.LENGTH_SHORT).show();
                            Toast.makeText(Tab_menu_details.this, "" + foodid, Toast.LENGTH_SHORT).show();
                            Toast.makeText(Tab_menu_details.this, "" + resid, Toast.LENGTH_SHORT).show();
                            Toast.makeText(Tab_menu_details.this, "" + uid, Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(Call<Resultcarttable> call, Throwable t) {
                            Toast.makeText(Tab_menu_details.this, "Already added ", Toast.LENGTH_SHORT).show();
                            Log.e("Error", String.valueOf(t));

                        }
                    });
                }
                String totalitem = String.valueOf(number);
                APInterface apInterface = APIClient.getClient().create(APInterface.class);
                Call<Resultcarttable> resultcarttableCall1 = apInterface.updatecart(uid, foodid, totalitem,resid);
                resultcarttableCall1.enqueue(new Callback<Resultcarttable>() {
                    @Override
                    public void onResponse(Call<Resultcarttable> call, Response<Resultcarttable> response) {
                        Intent intent = new Intent(Tab_menu_details.this, Tab_Menu_AddtoCart.class);
                        startActivity(intent);
                        Toast.makeText(Tab_menu_details.this, "cart updated ", Toast.LENGTH_SHORT).show();
                        Toast.makeText(Tab_menu_details.this, "" + uid, Toast.LENGTH_SHORT).show();
                        Toast.makeText(Tab_menu_details.this, "" + foodid, Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onFailure(Call<Resultcarttable> call, Throwable t) {
                        Toast.makeText(Tab_menu_details.this, "not added ", Toast.LENGTH_SHORT).show();
                        Log.e("Error", String.valueOf(t));

                    }
                });

            }
                /*APInterface apInterface = APIClient.getClient().create(APInterface.class);
                Call<Resultcarttable> call = apInterface.addtocart(uid, foodid, quantity_btn.getNumber());
                call.enqueue(new Callback<Resultcarttable>() {
                    @Override
                    public void onResponse(Call<Resultcarttable> call, Response<Resultcarttable> response) {
                        Intent intent = new Intent(Tab_menu_details.this, Tab_Menu_AddtoCart.class);
                        startActivity(intent);
                        Toast.makeText(Tab_menu_details.this, "cart added ", Toast.LENGTH_SHORT).show();
                        Toast.makeText(Tab_menu_details.this, "" + foodid, Toast.LENGTH_SHORT).show();
                        Toast.makeText(Tab_menu_details.this, "" + uid, Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(Call<Resultcarttable> call, Throwable t) {
                        Toast.makeText(Tab_menu_details.this, "not added ", Toast.LENGTH_SHORT).show();
                        Log.e("Error", String.valueOf(t));

                    }
                });*/


        });


    }

    /*private void getDisplay(int price) {
        TextView priceview=(TextView) findViewById(R.id.FoodPrice);
        priceview.setText(NumberFormat.getCurrencyInstance().format(price));
        priceview.setText("KES"+price);
    }*/


}

    /*
    homepage = (Homepage) getActivity();
            Homepage.toolbar.setVisibility(View.GONE);
            setHasOptionsMenu(false);*/
