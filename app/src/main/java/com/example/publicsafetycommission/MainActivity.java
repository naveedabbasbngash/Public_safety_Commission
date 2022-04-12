package com.example.publicsafetycommission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText name, phone, password,comdistrict, comemail,username, comaddress,
    comConcil, compguardian, comCnic, confrmpassword;
    TextView login;
    ImageButton showHideBtn;
    Spinner complainantgender,districtspinner;
    Button btn;
    TextView errorText,errorTexttwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.password);
        districtspinner=findViewById(R.id.districtspinner);
        comemail=findViewById(R.id.email);
        username=findViewById(R.id.userName);
        comaddress=findViewById(R.id.address);
        comConcil=findViewById(R.id.unionconcil);
        compguardian=findViewById(R.id.guardian);
        comCnic=findViewById(R.id.CNIC);
        complainantgender=findViewById(R.id.genderspinner);
        login=findViewById(R.id.textviewlogin);
        confrmpassword=findViewById(R.id.confirmPassword);
        //showHideBtn=findViewById(R.id.showHideBtn);
        btn=findViewById(R.id.Register);

        ArrayAdapter<CharSequence> myadapter = ArrayAdapter.createFromResource(this,
                R.array.districts, android.R.layout.simple_spinner_item);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        districtspinner.setAdapter(myadapter);
        districtspinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender, R.layout.my_selected_item);
        adapter.setDropDownViewResource(R.layout.my_dropdown_item);
        complainantgender.setAdapter(adapter);
        complainantgender.setOnItemSelectedListener(this);


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

                if(complainantgender.getSelectedItemPosition()==0){
                    errorText = (TextView)complainantgender.getSelectedView();
                    errorText.setError("");
                    errorText.setTextColor(Color.RED);
                    errorText.setText("Select gender");
                }
                if(districtspinner.getSelectedItemPosition()==0){
                    errorTexttwo = (TextView)districtspinner.getSelectedView();
                    errorTexttwo.setError("");
                    errorTexttwo.setTextColor(Color.RED);
                    errorTexttwo.setText("Select district");
                }
                if(password.getText().toString().equals(confrmpassword.getText().toString())){

                }else{
                    confrmpassword.setError("confirm password doesn't matches");
                    confrmpassword.setText("");
                }
                processdata(
                        username.getText().toString().trim(),
                        phone.getText().toString().trim(),
                        password.getText().toString().trim(),
                        String.valueOf(districtspinner.getSelectedItem()),
                        comemail.getText().toString().trim(),
                        name.getText().toString().trim(),
                        comaddress.getText().toString().trim(),
                        comConcil.getText().toString().trim(),
                        compguardian.getText().toString().trim(),
                        comCnic.getText().toString().trim(),
                        String.valueOf(complainantgender.getSelectedItem()));
            }
        });
    }

    public  void processdata(String user_name, String contact, String passwordd, String comdistric, String comemil, String compnam, String compaddress,
                             String comconcil, String compguardin, String comcnic,String comgender )
    {
        Call<Responsemodel> call= apiController.getInstance()
                .getapi()
                .getregister(user_name, contact,passwordd,comdistric, comemil,compnam,compaddress,
                        comconcil,compguardin,comcnic,comgender);

        call.enqueue(new Callback<Responsemodel>() {
            @Override
            public void onResponse(Call<Responsemodel> call, Response<Responsemodel> response) {

                Boolean valid = true;
                if ( TextUtils.isEmpty(user_name) ) {
                    name.setError("Username is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(contact) ) {
                    phone.setError("Contact is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(comdistric) ) {
                    comdistrict.setError("complainat district code is missing");
                    valid = false;
                }
                if ( TextUtils.isEmpty(passwordd) ) {
                    password.setError("Password is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(comemil) ) {
                    comemail.setError("complainant mail is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(compnam) ) {
                    username.setError("complainant name is missing");
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

                if ( TextUtils.isEmpty(compaddress) ) {
                    comaddress.setError("complainant address is missing");
                    valid = false;
                }


                if ( valid ) {
                    Responsemodel object=response.body();
                    String pass= password.getText().toString();
                    String cnfpass=confrmpassword.getText().toString();
                    if(object.getResponse()==1 && pass==cnfpass){
                        Toast.makeText(getApplicationContext(), object.getResponseMsg(), Toast.LENGTH_LONG).show();
                        Intent myintent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(myintent);
                    }else {
                        Toast.makeText(getApplicationContext(), object.getResponseMsg(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Responsemodel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "something went wrong", Toast.LENGTH_LONG).show();

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}