package com.example.foodyghar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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


public class Confirm_Password extends AppCompatActivity {

    TextInputLayout til_new_password, til_crfm_Password;
    EditText Ed_new_password, Ed_crfm_password;
    Button btncngpswd;
    ProgressDialog progressDialog;
    ArrayList<Savelogin> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_password);

        Ed_new_password = findViewById(R.id.Ed_new_password);
        Ed_crfm_password = findViewById(R.id.Ed_crfm_password);
        String contact = getIntent().getStringExtra("PhoneNo");
        arrayList = new ArrayList<>();
        btncngpswd = findViewById(R.id.btncngpswd);



        btncngpswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newpassword = Ed_new_password.getText().toString();
                String confirmpassword = Ed_crfm_password.getText().toString();
                APInterface apInterface = APIClient.getClient().create(APInterface.class);
                Call<Resultlogin> call = apInterface.update(contact, confirmpassword);
                call.enqueue(new Callback<Resultlogin>() {
                    @Override
                    public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                        arrayList = (ArrayList<Savelogin>) response.body().getSavelogin();
                        if (newpassword.equals(confirmpassword)) {

                            Toast.makeText(Confirm_Password.this, "Changed Password Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Confirm_Password.this, Login.class);
                            startActivity(intent);
                            finish();
                        } else {

                        }

                    }

                    @Override
                    public void onFailure(Call<Resultlogin> call, Throwable t) {

                    }
                });
                progressDialog = new ProgressDialog(Confirm_Password.this);
                progressDialog.setMessage("Please Wait");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();
                progressDialog.setCancelable(false);
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(5000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                }).start();

            }
        });
    }
}