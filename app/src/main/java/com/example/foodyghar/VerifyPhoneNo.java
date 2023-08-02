package com.example.foodyghar;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodyghar.Model.Resultlogin;
import com.example.foodyghar.Model.Savelogin;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import in.aabhasjindal.otptextview.OtpTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyPhoneNo extends AppCompatActivity {
    TextView numberforotp;
    OtpTextView otpverify;
    Button verifyotp,reg_submit;
    FirebaseAuth auth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    String verificationcode;
    ProgressDialog pd;
    ArrayList<Savelogin> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_no);

        numberforotp = findViewById(R.id.usenumberforotp);
        otpverify = findViewById(R.id.regotp_view);
        verifyotp = findViewById(R.id.verify_btn);
        reg_submit= findViewById(R.id.reg_submit);
        arrayList = new ArrayList<>();

        String firstname = getIntent().getStringExtra("FName");
        String lastname = getIntent().getStringExtra("LName");
        String contact = getIntent().getStringExtra("PhoneNo");
        String emailid = getIntent().getStringExtra("Email");
        String password = getIntent().getStringExtra("Password");

        numberforotp.setText(contact);
        pd = new ProgressDialog(this);
        numberforotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberforotp.setError("Please keep registered number and this same");
            }
        });

        reg_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = numberforotp.getText().toString();
                PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                        .setPhoneNumber("+91" + mobile)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(VerifyPhoneNo.this)                 // Activity (for callback binding)
                        .setCallbacks(mCallback)          // OnVerificationStateChangedCallbacks
                        .build();
                PhoneAuthProvider.verifyPhoneNumber(options);
                pd.setTitle("Sending OTP");
                pd.setMessage("Please wait");
                pd.setCancelable(false);
                pd.show();
            }
        });

        StartFirebaseLogin();

        verifyotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String code=numberforotp.getText().toString();
                String otp = otpverify.getOTP();

                if(code.isEmpty()||code.length()<6){
                    numberforotp.setError("Wrong OTP...");
                    numberforotp.requestFocus();
                    return;
                }

                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationcode, otp);
                SigninWithPhone(credential);
                APInterface apinterface= APIClient.getClient().create(APInterface.class);
                Call<Resultlogin> call=apinterface.insert(firstname,lastname,contact,emailid,password);
                call.enqueue(new Callback<Resultlogin>() {
                    @Override
                    public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                        arrayList= (ArrayList<Savelogin>) response.body().getSavelogin();

                        SharedPreferences pref=getSharedPreferences("mypref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor ed=pref.edit();
                        ed.putString("uid",arrayList.get(0).getuId());
                        ed.putString("firstname",arrayList.get(0).getFirstname());
                        ed.putString("lastname",arrayList.get(0).getLastname());
                        ed.putString("contact",arrayList.get(0).getContact());
                        ed.putString("emailid",arrayList.get(0).getEmailid());
                        ed.putString("password",arrayList.get(0).getPassword());
                        ed.apply();
                    }

                    @Override
                    public void onFailure(Call<Resultlogin> call, Throwable t) {

                    }
                });


            }
        });
    }

    private void StartFirebaseLogin() {

        auth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                Toast.makeText(VerifyPhoneNo.this, "verification completed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(VerifyPhoneNo.this, "verification failed", Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationcode = s;
                Toast.makeText(VerifyPhoneNo.this, "Code sent", Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }
        };

    }


    private void SigninWithPhone(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(VerifyPhoneNo.this, Login.class));
                            Toast.makeText(VerifyPhoneNo.this, "Details Submit", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(VerifyPhoneNo.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

}