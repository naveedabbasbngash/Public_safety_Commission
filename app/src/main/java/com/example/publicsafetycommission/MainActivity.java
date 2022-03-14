package com.example.publicsafetycommission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{
    EditText name, phone, password,roleIdfk,userstatus,comdistrict, comemail,compname, comaddress,
    comConcil, compguardian, comCnic, complainantgender;
    TextView login;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.userName);
        phone=findViewById(R.id.userContact);
        password=findViewById(R.id.userPassword);
        roleIdfk=findViewById(R.id.idfk);
        userstatus=findViewById(R.id.status);
        comdistrict=findViewById(R.id.complainantDistrict);
        comemail=findViewById(R.id.complainantEmail);
        compname=findViewById(R.id.complainantName);
        comaddress=findViewById(R.id.complainantAddress);
        comConcil=findViewById(R.id.complainantConcil);
        compguardian=findViewById(R.id.guardian);
        comCnic=findViewById(R.id.cnic);
        complainantgender=findViewById(R.id.gender);
        login=findViewById(R.id.textviewlogin);
        btn=findViewById(R.id.Register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processdata(
                        name.getText().toString().trim(),
                        phone.getText().toString().trim(),
                        password.getText().toString().trim(),
                        roleIdfk.getText().toString().trim(),
                        userstatus.getText().toString().trim(),
                        comdistrict.getText().toString().trim(),
                        comemail.getText().toString().trim(),
                        compname.getText().toString().trim(),
                        comaddress.getText().toString().trim(),
                        comConcil.getText().toString().trim(),
                        compguardian.getText().toString().trim(),
                        comCnic.getText().toString().trim(),
                        complainantgender.getText().toString().trim());
            }
        });
    }

    public  void processdata(String user_name, String contact, String passwordd, String roleidfkk,
                             String userstatu,String comdistric, String comemil, String compnam, String compaddress,
                             String comconcil, String compguardin, String comcnic,String comgender )
    {
        Call<responsemodel> call= apiController.getInstance()
                .getapi()
                .getregister(user_name, contact,passwordd,roleidfkk,userstatu,comdistric, comemil,compnam,compaddress,
                        comconcil,compguardin,comcnic,comgender);

        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {

                Boolean valid = true;
                if ( TextUtils.isEmpty(user_name) ) {
                    name.setError("Username is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(contact) ) {
                    phone.setError("Contact is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(passwordd) ) {
                    password.setError("Password is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(roleidfkk) ) {
                    roleIdfk.setError("address is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(userstatu) ) {
                    userstatus.setError("status is missing");
                    valid = false;
                }
                if ( TextUtils.isEmpty(comdistric) ) {
                    comdistrict.setError("complainat district code is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(comemil) ) {
                    comemail.setError("complainant mail is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(compnam) ) {
                    compname.setError("complainant name is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(comconcil) ) {
                    comConcil.setError("complainant UC is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(compguardin) ) {
                    compguardian.setError("complainant guardian is missing");
                    valid = false;
                }
                if ( TextUtils.isEmpty(comcnic) ) {
                    comCnic.setError("complainant cnic is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(comgender) ) {
                    complainantgender.setError("complainant gender is missing");
                    valid = false;
                }
                if ( TextUtils.isEmpty(compaddress) ) {
                    comaddress.setError("complainant address is missing");
                    valid = false;
                }


                if ( valid ) {
                    responsemodel object=response.body();
                    if(object.getResponse() == 1){
                        Toast.makeText(getApplicationContext(), object.getMessage(), Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent2);
                    }else {
                        Toast.makeText(getApplicationContext(), object.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_LONG).show();
                /*nametext.setText("");
                phonetext.setText("");
                passwordtext.setText("");
                roleIdfk.setText("");
                userstatus.setText("");
                comdistrict.setText("");
                comemail.setText("");
                compname.setText("");
                comaddress.setText("");
                comConcil.setText("");
                compguardian.setText("");
                comCnic.setText("");
                complainantgender.setText("");*/
            }
        });
    }
}