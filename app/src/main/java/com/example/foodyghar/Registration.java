package com.example.foodyghar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Registration extends AppCompatActivity {

    TextInputLayout til_RegFName, til_RegLName, til_RegMob, til_RegEmail;
    EditText txtfname, txtlname, contac, email,pass;
    Button btnsubmit;
    TextView retlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
//      getSupportActionBar().hide();

        til_RegFName = findViewById(R.id.til_RegFName);
        til_RegLName = findViewById(R.id.til_RegLName);
        txtfname = findViewById(R.id.txtfname);
        txtlname = findViewById(R.id.txtlname);
        contac = findViewById(R.id.contact);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.password);
        btnsubmit = findViewById(R.id.btnsubmit);
        retlogin = findViewById(R.id.retlogin);

        txtfname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Check Condition

                if (!charSequence.toString().isEmpty() && !charSequence.toString().matches("[a-zA-Z ]+")) {
                    //When value is not equal to empty and contain numeric value
                    //Show error
                    til_RegFName.setError("Allow Only Character(A-Z a-z)");
                } else {
                    //When value is equal to character only
                    //Hide error

                    til_RegFName.setError(null);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtlname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Check Condition

                if (!charSequence.toString().isEmpty() && !charSequence.toString().matches("[a-zA-Z ]+")) {
                    //When value is not equal to empty and contain numeric value
                    //Show error
                    til_RegLName.setError("Allow Only Character(A-Z a-z)");
                } else {
                    //When value is equal to character only
                    //Hide error

                    til_RegLName.setError(null);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

       /*SharedPreferences pref = getSharedPreferences("mypref", Context.MODE_PRIVATE);
        boolean b = pref.getBoolean("isReg", false);
        if (b) {
            Intent intent = new Intent(Registration.this, Homepage.class);
            startActivity(intent);
            finish();
        }*/

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = txtfname.getText().toString();
                String lastname = txtlname.getText().toString();
                String contact = contac.getText().toString();
                String emailid = email.getText().toString();
                String password = pass.getText().toString();

                Toast.makeText(Registration.this,"Verify Your Phone Number",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Registration.this,VerifyPhoneNo.class);
                intent.putExtra("FName",firstname);
                intent.putExtra("LName",lastname);
                intent.putExtra("PhoneNo",contact);
                intent.putExtra("Email",emailid);
                intent.putExtra("Password",password);
                startActivity(intent);

                AlertDialog alertDialog = new AlertDialog.Builder(Registration.this)

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setMessage("Please Wait")
                        .show();


            }
        });


        retlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, Login.class);
                startActivity(intent);
            }
        });


    }
/*    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(getApplicationContext(), gender[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView){
    }*/

}





