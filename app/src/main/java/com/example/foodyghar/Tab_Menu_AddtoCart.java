package com.example.foodyghar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodyghar.Adapter.CartAdapter;
import com.example.foodyghar.Model.Carttable;
import com.example.foodyghar.Model.Paymentdetail;
import com.example.foodyghar.Model.RestaurantCategory;
import com.example.foodyghar.Model.ResultPaymentdetails;
import com.example.foodyghar.Model.Resultcarttable;
import com.example.foodyghar.Model.Savelogin;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.example.foodyghar.frag.Home_frag;
import com.example.foodyghar.frag.Hotel_detail_fragment;
import com.example.foodyghar.frag.Tab_Menu;
import com.github.ybq.android.spinkit.SpinKitView;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tab_Menu_AddtoCart extends AppCompatActivity implements PaymentResultListener {
    static RecyclerView cartItemsRecyclerView;
    ImageView close_button_info;
    TextView buttonPlaceYourOrder, reservation_id_info, restname;
    public static TextView tvTotalAmount;
    static ArrayList<Carttable> arrayList;
    public static Context context;
    static String id;
    static ArrayList<Paymentdetail> paymentdetailArrayList;
    static ArrayList<RestaurantCategory> restaurantCategories;
    static SpinKitView spin_kitforcart;
    Homepage homepage;
    String h_id, b_id, u_id, c_id, b_date, h_cost, menu_amt,h_name,h_address;
    String status;
    //  ArrayList<RestaurantCategory> restaurantCategoryArrayList;

    String amount;

    static String resid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_menu_addto_cart);
        context = this;
        tvTotalAmount = findViewById(R.id.tvTotalAmount);

        SharedPreferences pref2 = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String contac = pref2.getString("contact", null);
        String eml = pref2.getString("emailid", null);



        buttonPlaceYourOrder = findViewById(R.id.buttonPlaceYourOrder);
        reservation_id_info = findViewById(R.id.reservation_id_info);
        restname = findViewById(R.id.restname);
        spin_kitforcart = findViewById(R.id.spin_kitforcart);
        close_button_info = findViewById(R.id.close_button_info);

        cartItemsRecyclerView = findViewById(R.id.cartItemsRecyclerView);
        cartItemsRecyclerView.setHasFixedSize(true);
        cartItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<>();
        restaurantCategories = new ArrayList<>();
        paymentdetailArrayList = new ArrayList<>();


        spin_kitforcart.setVisibility(View.VISIBLE);


        SharedPreferences pref = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        id = pref.getString("uid", null);
        resid = pref.getString("hotel_id", null);
        b_id = pref.getString("b_id", null);
         h_name = pref.getString("hotel_name", null);
         h_address = pref.getString("hotel_add", null);
        h_cost = pref.getString("hotel_cost", null);
        String b_nslot = pref.getString("b_nslot", null);
        b_date = pref.getString("b_date", null);
        String b_tbm = pref.getString("b_tbm", null);
        String b_tslot = pref.getString("b_tslot", null);
        h_id = pref.getString("hotel_id", null);
        b_id = pref.getString("b_id", null);
        u_id = pref.getString("uid", null);
        c_id = pref.getString("cart_id", null);
        String cart_id = pref.getString("cart_id", null);
        reservation_id_info.setText(cart_id);
        restname.setText(h_name);

        cartItemsRecyclerView.setHasFixedSize(true);
        cartItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        add();

        close_button_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent= new Intent(Tab_Menu_AddtoCart.this, Tab_menu_details.class);
                startActivity(intent);*/
                finish();
            }
        });

        amount = "500";

        //convert and round off
       /* String NewString = menu_amt.replaceAll("₹", "");
        menu_amt = NewString;*/
        amount = String.valueOf(Math.round(Float.parseFloat(amount) * 100));

        String finalAmount = amount;

        buttonPlaceYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent i = new Intent(Tab_Menu_AddtoCart.this, Homepage.class);
                i.putExtra("load", "load");
                startActivity(i);
                finish();*/

                //Initialize razorpay checkout

                Checkout checkout = new Checkout();
                //set key id
                checkout.setKeyID("rzp_test_80EKGCHq8YuY5Q");
                //set image
                checkout.setImage(R.drawable.logo);
                //initialize object
                JSONObject object = new JSONObject();
                try {
                    //put name.
                    object.put("Name", "FoodyGhar");
                    //put description
                    object.put("description", "payment");
                    //put theme color
                    object.put("themecolor", "FF2B0202");
                    // currency unit
                    object.put("currency", "INR");
                    // amount
                    object.put("amount", finalAmount);
                    // mobile number
                    object.put("prefill.contact", contac);
                    // email
                    object.put("prefill.email", eml);
                    // open razorpay checkout
                    checkout.open(Tab_Menu_AddtoCart.this, object);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }



        });
    }

    public static void add() {

        APInterface apInterface = APIClient.getClient().create(APInterface.class);
        Call<Resultcarttable> call = apInterface.showcart(id,resid);
        call.enqueue(new Callback<Resultcarttable>() {
            @Override
            public void onResponse(Call<Resultcarttable> call, Response<Resultcarttable> response) {
                arrayList = (ArrayList<Carttable>) response.body().getCarttable();
                CartAdapter cartAdapter = new CartAdapter(context, arrayList);
                cartItemsRecyclerView.setAdapter(cartAdapter);

                SharedPreferences pref2 =context.getSharedPreferences("mypref", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = pref2.edit();
                ed.putString("cart_id", arrayList.get(0).getCartId());
                ed.apply();

                int i, total_amount = 0;
                for (i = 0; i < arrayList.size(); i++) {
                    int price = Integer.parseInt(arrayList.get(i).getFoodprice());
                    int total = arrayList.get(i).getTotal_item();
                    int total_all = price * total;
                    total_amount = total_amount + total_all;
                }
                Tab_Menu_AddtoCart.tvTotalAmount.setText("₹" + String.valueOf(total_amount));
                spin_kitforcart.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<Resultcarttable> call, Throwable t) {
                Toast.makeText(context, "No Item in Cart", Toast.LENGTH_SHORT).show();
                spin_kitforcart.setVisibility(View.INVISIBLE);
            }
        });


    }

    @Override
    public void onPaymentSuccess(String s) {
        // intilize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //set title
        builder.setTitle("PaymentID");
        //set message
        builder.setMessage(s);
        //show alert dialog
        builder.show();
        try {
            int i_loop;
       /* int main;
        String main_str = "";
        for (main = 0; main < cartarrayList.size(); main++) {
            main_str = main_str + cartarrayList.get(main).getCartId() + ",";
        }
        Log.e("Total Orders", main_str);*/
            APInterface apInterface = APIClient.getClient().create(APInterface.class);
            // Intent i = new Intent(Tab_home_tblbook_confirm.this, Hotel_detail_fragment.class);


            //String uid = cartarrayList.get(i_loop).getuId();
            //  String cart_id = cartarrayList.get(i_loop).getCartId();
            //b_id = reservation_id_info.getText().toString();
           // String amount = res_cost_info.getText().toString();
            //  String status = paymentdetailArrayList.get(i_loop).getStatus();
            status = "success";
            //String NewString = menu_amt.replaceAll("₹","");
            menu_amt = String.valueOf(500);
           //  menu_amt = menu_amt;
            Log.e("ERROR", String.valueOf(h_id + u_id + b_id + c_id + b_date + " " + menu_amt + status ));
            Call<ResultPaymentdetails> call = apInterface.getpaymentdetail(Integer.parseInt(resid), Integer.parseInt(u_id), Integer.parseInt(b_id), Integer.parseInt(c_id), "0", menu_amt,status,"preorder");
            call.enqueue(new Callback<ResultPaymentdetails>() {
                @Override
                public void onResponse(Call<ResultPaymentdetails> call, Response<ResultPaymentdetails> response) {
                    paymentdetailArrayList = (ArrayList<Paymentdetail>) response.body().getPaymentdetails();
                    Intent intent = new Intent(Tab_Menu_AddtoCart.this, Payment_successfully_menu.class);
                    Toast.makeText(Tab_Menu_AddtoCart.this, "Successfully insert", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    SharedPreferences pref3 =context.getSharedPreferences("mypref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor ed = pref3.edit();
                    ed.putString("menuprice", paymentdetailArrayList.get(0).getMenuamt());
                    ed.apply();
                    finish();

                }

                @Override
                public void onFailure(Call<ResultPaymentdetails> call, Throwable t) {
                    Toast.makeText(Tab_Menu_AddtoCart.this, "failed to insert payment", Toast.LENGTH_SHORT).show();
                    Log.e("FAILTOINSERT", String.valueOf(t));
                }
            });

            // Toast.makeText(Tab_home_tblbook_confirm.this, "Payment Successful", Toast.LENGTH_SHORT).show();


        } catch (Exception ignored) {
            Log.e("Error", String.valueOf(ignored));
        }

    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(context, "s", Toast.LENGTH_SHORT).show();
    }
}
