package com.example.foodyghar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodyghar.Model.Resultlogin;
import com.example.foodyghar.Model.Savelogin;
import com.example.foodyghar.Webservice.APIClient;
import com.example.foodyghar.Webservice.APInterface;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
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


public class forget_password extends AppCompatActivity {

    TextView rotp;
    Button btngetotp,btnverify;
    TextInputLayout til_FpMob;
    EditText EdFp_Con;
    OtpTextView otpTextView;
    FirebaseAuth auth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback;
    ArrayList<Savelogin> arrayList;
    String verificationCode,contact;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        rotp = findViewById(R.id.rotp);
        btngetotp = findViewById(R.id.btngetotp);
        EdFp_Con = findViewById(R.id.EdFp_Con);
        btnverify = findViewById(R.id.btnverify);
        otpTextView = findViewById(R.id.otp_view);

        arrayList = new ArrayList<>();
        contact = getIntent().getStringExtra("PhoneNo");
        EdFp_Con.setText(contact);
        pd = new ProgressDialog(this);
        EdFp_Con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdFp_Con.setError("Please keep registered number and this same");
            }
        });



        btngetotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(forget_password.this, "Check Message", Toast.LENGTH_SHORT).show();

            }
        });

        btngetotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contact = EdFp_Con.getText().toString();
                APInterface apiInterface = APIClient.getClient().create(APInterface.class);
                Call<Resultlogin> call = apiInterface.otplogin(contact);
                call.enqueue(new Callback<Resultlogin>() {
                    @Override
                    public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                        arrayList = (ArrayList<Savelogin>) response.body().getSavelogin();

                        String s1 = arrayList.get(0).getContact();
                        if (s1.equals(contact)) {

                            Toast.makeText(forget_password.this, "Number Confirmed", Toast.LENGTH_SHORT).show();
                            PhoneAuthOptions options = PhoneAuthOptions.newBuilder(auth)
                                    .setPhoneNumber("+91" + contact)       // Phone number to verify
                                    .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                                    .setActivity(forget_password.this)                 // Activity (for callback binding)
                                    .setCallbacks(mCallback)          // OnVerificationStateChangedCallbacks
                                    .build();
                            PhoneAuthProvider.verifyPhoneNumber(options);
                            pd.setTitle("Sending OTP");
                            pd.setMessage("Please wait");
                            pd.setCancelable(false);
                            pd.show();

                        } else {
                            Toast.makeText(forget_password.this, "Please Enter Valid Number Or Create Account", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Resultlogin> call, Throwable t) {
                        Toast.makeText(forget_password.this, "Please Enter Valid Number Or Create Account", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        StartFirebaseLogin();

        btnverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code=EdFp_Con.getText().toString();
                String otp = otpTextView.getOTP();


                if (code.isEmpty() || code.length() < 6) {
                    EdFp_Con.setError("Wrong OTP...");
                    EdFp_Con.requestFocus();
                    return;
                }
               /* PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otp);
                SigninWithPhone(credential);
*/

                verifyCode(otp);
            }
        });


        //Data Base phone number verif

        rotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(forget_password.this, "Check Message Again", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void StartFirebaseLogin() {

        auth = FirebaseAuth.getInstance();
        mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
             /*   String code = phoneAuthCredential.getSmsCode();
                if (code != null) {
                    verifyCode(code);
                }*/
                Toast.makeText(forget_password.this, "Verification Completed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(forget_password.this, "verification failed", Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verificationCode = s;
                Toast.makeText(forget_password.this, "Code sent", Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }
        };
    }

    private void verifyCode(String otp) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otp);
        SigninWithPhone(credential);
    }

        private void SigninWithPhone (PhoneAuthCredential credential)
        {
            auth.signInWithCredential(credential)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                /*startActivity(new Intent(forget_password.this, Confirm_Password.class));*/
                                Intent intent=new Intent(getApplicationContext(),Confirm_Password.class);
                                intent.putExtra("PhoneNo",contact);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                Toast.makeText(forget_password.this, "OTP Verified", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(forget_password.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

        }


        /*btngetotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = EdFp_Con.getText().toString();
                String otp = otpTextView.getOTP();

                if(phone.isEmpty()||phone.length()<6){
                    EdFp_Con.setError("Wrong OTP...");
                    EdFp_Con.requestFocus();
                    return;
                }

                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, otp);
                signInTheUserByCredentials(credential);
                APInterface apiInterface = APIClient.getClient().create(APInterface.class);
                Call<Resultlogin> call = apiInterface.otplogin(phone);
                call.enqueue(new Callback<Resultlogin>() {
                    @Override
                    public void onResponse(Call<Resultlogin> call, Response<Resultlogin> response) {
                        arrayList = (ArrayList<Savelogin>) response.body().getSavelogin();

                        String s1 = arrayList.get(0).getContact();
                        if (s1.equals(phone)) {

                            Toast.makeText(forget_password.this, "Number Confirmed", Toast.LENGTH_SHORT).show();

                            sendVerificationCodeToUser(phone);
                        } else {
                            Toast.makeText(forget_password.this, "Please Enter Valid Number Or Create Account", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Resultlogin> call, Throwable t) {
                        Toast.makeText(forget_password.this, "Please Enter Valid Number Or Create Account", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });
        StartFirebaseLogin();




    private void sendVerificationCodeToUser(String phone) {

    }



    }

    *//*private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallback = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationCode = s;
        }

        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
               // progressBar.setVisibility(View.VISIBLE);
                verifyCode(code);
            }

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(forget_password.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };
*//*
    *//*private void verifyCode(String codeByUser) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, codeByUser);
        signInTheUserByCredentials(credential);
    }*//*

    private void signInTheUserByCredentials(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(forget_password.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(getApplicationContext(), Confirm_Password.class);
                            intent.putExtra("PhoneNo",phone);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            Toast.makeText(forget_password.this, "verfied Sucessfully", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(forget_password.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    *//*private void SigninWithPhone(PhoneAuthCredential credential) {
        auth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(forget_password.this, Confirm_Password.class));
                            Toast.makeText(forget_password.this, "OTP Verified", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(forget_password.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }*//**/
}