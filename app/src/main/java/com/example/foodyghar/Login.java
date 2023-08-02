package com.example.foodyghar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodyghar.Model.Resultlogin;
import com.example.foodyghar.Model.Savelogin;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Login extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    Button btnlogin, btnsignup;
    EditText txtemail, txtpassword;
    TextView txtforpswd, skip_btn;
    CheckBox rememberme;
    Button btn_retryinternet;
    ProgressDialog progressDialog;

    ArrayList<Savelogin> arrayList;
    boolean isChecked1=false;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getSupportActionBar().hide();

        /*ConstraintLayout your_Layout = (ConstraintLayout) findViewById(R.id.main_container);
        AnimationDrawable animationDrawable = (AnimationDrawable) your_Layout.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


*/
        skip_btn = findViewById(R.id.skip_btn);
        btnlogin = findViewById(R.id.btnlogin);
        btnsignup = findViewById(R.id.btnsignup);
        txtemail = findViewById(R.id.txtemail);
        txtpassword = findViewById(R.id.txtpassword);
        txtforpswd = findViewById(R.id.txtforpswd);
        rememberme = findViewById(R.id.rememberme);

        arrayList = new ArrayList<>();

        SharedPreferences pref = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        boolean b = pref.getBoolean("isLog", false);
        boolean b1 = pref.getBoolean("remember", false);
        if (b) {
            Intent intent = new Intent(Login.this, Homepage.class);
            startActivity(intent);
            finish();
        }
        if(b1)
        {
            String e1=pref.getString("emailid", null);
            String p1=pref.getString("password", null);
            txtemail.setText(e1);
            txtpassword.setText(p1);
        }
        else {
            txtemail.setText("");
            txtpassword.setText("");
        }

        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Homepage.class);
                startActivity(i);
                finish();
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isConnected(Login.this)) {
                    Dialog dialog = new Dialog(Login.this, R.style.NointernetDialog);
                    dialog.setContentView(R.layout.no_internet_dialog);
                    btn_retryinternet = dialog.findViewById(R.id.btn_retryinternet);
                    btn_retryinternet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (isConnected(Login.this)) {
                                dialog.dismiss();
                            } else {
                                Toast.makeText(Login.this, "Please Connect your Mobile with Network", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });

                    dialog.show();
                }
                //till here internet


                progressDialog = new ProgressDialog(Login.this);
                progressDialog.setMessage("Please Wait");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();

                String emailid = txtemail.getText().toString();
                String password = txtpassword.getText().toString();
                APInterface apInterface = APIClient.getClient().create(APInterface.class);
                Call<Resultlogin> call = apInterface.login(emailid, password);
                call.enqueue(new Callback<Resultlogin>() {
                    @Override
                    public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                        arrayList = (ArrayList<Savelogin>) response.body().getSavelogin();
                        //String id=arrayList.get(0).getId();
                        String el = arrayList.get(0).getEmailid();
                        String ps = arrayList.get(0).getPassword();


                        if (el.equals(emailid) && ps.equals(password)) {

                            SharedPreferences pref = getSharedPreferences("mypref", Context.MODE_PRIVATE);
                            SharedPreferences.Editor ed = pref.edit();
                            ed.putString("uid", arrayList.get(0).getuId());
                            ed.putString("firstname", arrayList.get(0).getFirstname());
                            ed.putString("lastname", arrayList.get(0).getLastname());
                            ed.putString("contact", arrayList.get(0).getContact());
                            ed.putString("emailid", arrayList.get(0).getEmailid());
                            ed.putString("password", arrayList.get(0).getPassword());
                            ed.putString("img", arrayList.get(0).getImg());
                            ed.putBoolean("isLog", true);
                            ed.putBoolean("skip", true);
                            ed.putBoolean("remember", isChecked1);
                            ed.apply();

                            Toast.makeText(Login.this, "Welcome FoodyGhar", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, Homepage.class);
                            startActivity(intent);
                            finish();
                            progressDialog.dismiss();
                        } else {
                            Toast.makeText(Login.this, "Invalid Emailid and Password", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }


                    }

                    @Override
                    public void onFailure(Call<Resultlogin> call, Throwable t) {
                        Toast.makeText(Login.this, "Enter Your Emailid and Password", Toast.LENGTH_SHORT).show();
                        Log.e("Error", String.valueOf(t));
                    }
                });


            }
        });


        txtforpswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, forget_password.class);
                startActivity(intent);
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);

            }
        });

        if (!isConnected(Login.this)) {
            Dialog dialog = new Dialog(Login.this, R.style.NointernetDialog);
            dialog.setContentView(R.layout.no_internet_dialog);
            Button btn_retryinternet;
            btn_retryinternet = dialog.findViewById(R.id.btn_retryinternet);
            btn_retryinternet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isConnected(Login.this)) {
                        dialog.dismiss();
                    } else {
                        Toast.makeText(Login.this, "Please Connect your Mobile with Network", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            });

            dialog.show();
        }

        rememberme.setOnCheckedChangeListener(this);
    }

    public boolean isConnected(Login login) {

        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifiConn != null && wifiConn.isConnected() || (mobileConn != null && mobileConn.isConnected()))) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(buttonView==rememberme)
        {
            isChecked1=isChecked;
        }
        else {
            isChecked1=isChecked;
        }
    }
}