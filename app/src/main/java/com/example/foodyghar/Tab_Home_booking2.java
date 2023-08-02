package com.example.foodyghar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.foodyghar.Adapter.TimeSloatAdapter;
import com.example.foodyghar.Model.Bookslot;
import com.example.foodyghar.Model.ResultTimeslot;
import com.example.foodyghar.Model.Resultbookslot;
import com.example.foodyghar.Model.Resultlogin;
import com.example.foodyghar.Model.Savelogin;
import com.example.foodyghar.Model.Timeslot;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tab_Home_booking2 extends AppCompatActivity {

    //pick date calendar
    final Calendar myCalendar = Calendar.getInstance(TimeZone.getDefault());
    TextView booking_current_page_text, booking_current_page_restuarant_name, current_date_textview;
    TextView foodie_count, time_slot_errortext;
    CardView minus_foodie_button, booking_info_complete_button, add_foodie_button;
    private LinearLayout booking_info_section;
    Button pick_date_btn;
    RecyclerView time_slot_recyclerview;
    EditText input_name, input_email, input_phone;
    ImageView close_button_tblbookinfo;

    ElegantNumberButton foodie_count_btn;

    Homepage homepage;
    String h_id, u_id,b_id;
    ArrayList<Timeslot> arrayListtiemslot;
    ArrayList<Bookslot> bookslotArrayList;
    String bookdate, member;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_home_booking2);
//        getSupportActionBar().hide();
        booking_current_page_text = findViewById(R.id.booking_current_page_text);
        booking_current_page_restuarant_name = findViewById(R.id.booking_current_page_restuarant_name);
        current_date_textview = findViewById(R.id.current_date_textview);
        pick_date_btn = findViewById(R.id.pick_date_btn);
        foodie_count = findViewById(R.id.foodie_count);
        foodie_count_btn = findViewById(R.id.foodie_count_btn);
        booking_info_complete_button = findViewById(R.id.booking_info_complete_button);
        time_slot_recyclerview = findViewById(R.id.time_slot_recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        time_slot_recyclerview.setLayoutManager(linearLayoutManager);
        input_name = findViewById(R.id.input_name);
        input_email = findViewById(R.id.input_email);
        input_phone = findViewById(R.id.input_phone);
        close_button_tblbookinfo = findViewById(R.id.close_button_tblbookinfo);

        arrayListtiemslot = new ArrayList<>();
        bookslotArrayList = new ArrayList<>();
/*
        String bookdate = getIntent().getStringExtra("BDate");
        String totalbookmber = getIntent().getStringExtra("TBookM");
        String timslot = getIntent().getStringExtra("TSlot");
        String slotname = getIntent().getStringExtra("SlName");
        String slotemail = getIntent().getStringExtra("SEmail");
        String slotmobile = getIntent().getStringExtra("SMob");*/


        try {
            SharedPreferences pref = getSharedPreferences("mypref", Context.MODE_PRIVATE);
            h_id = pref.getString("hotel_id", null);
            u_id = pref.getString("uid", null);
            String h_name = pref.getString("hotel_name", null);
            booking_current_page_restuarant_name.setText(h_name);
        } catch (Exception e) {

        }


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();
            }

        };

        pick_date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Tab_Home_booking2.this, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

        close_button_tblbookinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        foodie_count_btn = findViewById(R.id.foodie_count_btn);
        foodie_count_btn.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                int num = newValue;
                foodie_count.setText(num + " Foodies");
                Toast.makeText(Tab_Home_booking2.this, "" + num, Toast.LENGTH_SHORT).show();
                member = String.valueOf(newValue);
            }
        });
        booking_info_complete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(Tab_Home_booking2.this, "click" + TimeSloatAdapter.Mytime, Toast.LENGTH_SHORT).show();
                String slotname = input_name.getText().toString();
                String slotemail = input_email.getText().toString();
                String slotmobile = input_phone.getText().toString();



                APInterface apinterface = APIClient.getClient().create(APInterface.class);
                Call<Resultbookslot> call = apinterface.bookslot(bookdate,  member, TimeSloatAdapter.Mytime, slotname, slotemail, slotmobile, u_id, h_id,b_id);
                call.enqueue(new Callback<Resultbookslot>() {
                    @Override
                    public void onResponse(Call<Resultbookslot> call, Response<Resultbookslot> response) {


                        Toast.makeText(Tab_Home_booking2.this, "Done", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Tab_Home_booking2.this, Tab_home_tblbook_confirm.class);
                        bookslotArrayList= (ArrayList<Bookslot>) response.body().getBookslot();
                        SharedPreferences pref=getSharedPreferences("mypref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor ed=pref.edit();
                        ed.putString("b_id",bookslotArrayList.get(0).getBookid());
                        ed.putString("b_date",bookdate);
                        ed.putString("b_tbm",foodie_count_btn.getNumber());
                        ed.putString("b_tslot",TimeSloatAdapter.Mytime);
                        ed.putString("b_nslot",input_name.getText().toString());
                        ed.putString("b_eslot",input_email.getText().toString());
                        ed.putString("b_mslot",input_phone.getText().toString());
                        ed.apply();
                        startActivity(intent);



                    }

                    @Override
                    public void onFailure(Call<Resultbookslot> call, Throwable t) {
                        Toast.makeText(Tab_Home_booking2.this, "Not Done", Toast.LENGTH_SHORT).show();
                        Log.e("Error", String.valueOf(t));
                    }
                });


            }
        });
        gettieslot();
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        //  dateFormat.getDateInstance(DateFormat.SHORT).format(myFormat);
        current_date_textview.setText(dateFormat.format(myCalendar.getTime()));
        bookdate = dateFormat.format(myCalendar.getTime());
    }

    public void gettieslot() {
        APInterface apInterface = APIClient.getClient().create(APInterface.class);
        Call<ResultTimeslot> call = apInterface.gettimeslot(h_id);
        call.enqueue(new Callback<ResultTimeslot>() {
            @Override
            public void onResponse(Call<ResultTimeslot> call, Response<ResultTimeslot> response) {
                arrayListtiemslot = (ArrayList<Timeslot>) response.body().getTimeslot();
                TimeSloatAdapter timeSloatAdapter = new TimeSloatAdapter(Tab_Home_booking2.this, arrayListtiemslot);
                time_slot_recyclerview.setAdapter(timeSloatAdapter);
            }

            @Override
            public void onFailure(Call<ResultTimeslot> call, Throwable t) {

            }
        });
    }
}