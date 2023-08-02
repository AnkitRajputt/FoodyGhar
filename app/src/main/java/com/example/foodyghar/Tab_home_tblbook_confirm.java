package com.example.foodyghar;

import static com.example.foodyghar.Tab_Menu_AddtoCart.context;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodyghar.Model.Carttable;
import com.example.foodyghar.Model.Paymentdetail;
import com.example.foodyghar.Model.RestaurantCategory;
import com.example.foodyghar.Model.ResultPaymentdetails;
import com.example.foodyghar.Model.Savelogin;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.example.foodyghar.frag.Hotel_detail_fragment;
import com.example.foodyghar.frag.Tab_Menu;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tab_home_tblbook_confirm extends AppCompatActivity implements PaymentResultListener {

    static ArrayList<Carttable> cartarrayList;
    static ArrayList<Paymentdetail> paymentdetailArrayList;
    ImageView close_button_det;
    LinearLayout payment_btn;
    // Tab_home_tblbook_confirm tab_home_tblbook_confirm;
    TextView reservation_id_info, res_spot_name_info, res_date_info,
            res_time_info, res_foodiecount_info, top_spot_name, top_spot_location, res_cost_info;
    String h_id, b_id, u_id, c_id, b_date, h_cost, menu_amt;
    String status;
    //  ArrayList<RestaurantCategory> restaurantCategoryArrayList;

    String amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_home_tblbook_confirm);

        reservation_id_info = findViewById(R.id.reservation_id_info);
        res_spot_name_info = findViewById(R.id.res_spot_name_info);
        res_date_info = findViewById(R.id.res_date_info);
        res_time_info = findViewById(R.id.res_time_info);
        res_foodiecount_info = findViewById(R.id.res_foodiecount_info);
        close_button_det = findViewById(R.id.close_button_det);
        payment_btn = findViewById(R.id.confrm_but);
        top_spot_name = findViewById(R.id.top_spot_name);
        top_spot_location = findViewById(R.id.top_spot_location);
        res_cost_info = findViewById(R.id.res_cost_info);

        SharedPreferences pref1 = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        String contac = pref1.getString("contact", null);
        String eml = pref1.getString("emailid", null);


        // restaurantCategoryArrayList=new ArrayList<>();

        SharedPreferences pref = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        b_id = pref.getString("b_id", null);
        String h_name = pref.getString("hotel_name", null);
        String h_address = pref.getString("hotel_add", null);
        h_cost = pref.getString("hotel_cost", null);
        String b_nslot = pref.getString("b_nslot", null);
        b_date = pref.getString("b_date", null);
        String b_tbm = pref.getString("b_tbm", null);
        String b_tslot = pref.getString("b_tslot", null);
        h_id = pref.getString("hotel_id", null);
        b_id = pref.getString("b_id", null);
        u_id = pref.getString("uid", null);
        c_id = pref.getString("cart_id", null);

        reservation_id_info.setText(b_id + "");
        top_spot_name.setText(h_name);
        top_spot_location.setText(h_address);
        res_spot_name_info.setText(b_nslot);
        res_date_info.setText(b_date);
        res_time_info.setText(b_tslot);
        res_foodiecount_info.setText(b_tbm + " Foodies");
        res_cost_info.setText(h_cost);

        close_button_det.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tab_home_tblbook_confirm.this, Tab_Home_booking2.class);
                startActivity(intent);
                finish();
            }
        });

        //Initialize amount
        amount = "200";

        //convert and round off
        String NewString = h_cost.replaceAll("₹", "");
        h_cost = NewString;
        amount = String.valueOf(Math.round(Float.parseFloat(NewString) * 100));

        String finalAmount = amount;


        payment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
                    checkout.open(Tab_home_tblbook_confirm.this, object);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
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
             amount = res_cost_info.getText().toString();
            //  String status = paymentdetailArrayList.get(i_loop).getStatus();
            status = "success";
            String NewString = h_cost.replaceAll("₹", "");
            h_cost = NewString;
           // menu_amt = h_cost;
            Log.e("ERROR", String.valueOf(h_id + u_id + b_id + c_id + b_date + h_cost + menu_amt + status ));
            Call<ResultPaymentdetails> call = apInterface.getpaymentdetail(Integer.parseInt(h_id), Integer.parseInt(u_id), Integer.parseInt(b_id), Integer.parseInt(c_id), h_cost, "null",status,"table");
            call.enqueue(new Callback<ResultPaymentdetails>() {
                @Override
                public void onResponse(Call<ResultPaymentdetails> call, Response<ResultPaymentdetails> response) {
                    Intent intent = new Intent(Tab_home_tblbook_confirm.this, Payment_successfully.class);
                    Toast.makeText(Tab_home_tblbook_confirm.this, "Successfully insert", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<ResultPaymentdetails> call, Throwable t) {
                    Toast.makeText(Tab_home_tblbook_confirm.this, "failed to insert payment", Toast.LENGTH_SHORT).show();
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

   /* private void loadfragment(Tab_Menu tab_menu) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frmid, tab_menu)
                .commit();

    }*/

}