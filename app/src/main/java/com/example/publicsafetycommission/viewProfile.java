package com.example.publicsafetycommission;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class viewProfile extends AppCompatActivity {

    ImageView backarrow, profileImg;
    EditText fullname,cnic,gender,guardian,email,district,uc, address, phone,username;
    Button update;
    public static final int SELECT_PICTURE = 1;
    String path;
    File file1;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        backarrow=findViewById(R.id.btnBack);
        fullname=findViewById(R.id.fullName);
        cnic=findViewById(R.id.CNIC);
        gender=findViewById(R.id.gender);
        guardian=findViewById(R.id.guardian);
        email=findViewById(R.id.emailAddress);
        district=findViewById(R.id.district);
        uc=findViewById(R.id.unionCouncil);
        address=findViewById(R.id.address);
        phone=findViewById(R.id.phoneNo);
        username=findViewById(R.id.userName);
        update=findViewById(R.id.update);
        profileImg = findViewById(R.id.profileImage);


        SharedPreferences spref = getSharedPreferences("YOUR_PREF_NAME", 0);
        int userid = spref.getInt("user_id", 0);

        processdata(userid);

        profileImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePro(
                        fullname.getText().toString().trim(),
                        cnic.getText().toString().trim(),
                        gender.getText().toString().trim(),
                        guardian.getText().toString().trim(),
                        email.getText().toString().trim(),
                        district.getText().toString().trim(),
                        uc.getText().toString().trim(),
                        address.getText().toString().trim(),
                        phone.getText().toString().trim(),
                        username.getText().toString().trim(),
                        userid);
            }
        });

        backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(viewProfile.this, HomeActivity.class);
                startActivity(newIntent);
            }
        }); //user_avatar
    }

    private void pickImage() {
        Intent inte = new Intent();
        inte.setType("image/*");
        inte.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(inte, "Select Picture"), SELECT_PICTURE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == SELECT_PICTURE) {
            uri = data.getData();
            Context context = viewProfile.this;
            path = RealPathUtil.getRealPath(context, uri);
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            profileImg.setImageURI(uri);
        }
    }

    private void updatePro(String fullnameg, String cnicg, String genderg, String guardiang, String emailg, String districtg,
                           String ucg, String addressg, String phoneg, String usernameg, int useridg) {
        Call<Responsemodel> call= apiController.getInstance()
                .getapi()
                .getUpdate(fullnameg, cnicg,genderg,guardiang, emailg,districtg,ucg,
                        addressg,phoneg,usernameg,useridg);

        call.enqueue(new Callback<Responsemodel>() {
            @Override
            public void onResponse(Call<Responsemodel> call, Response<Responsemodel> response) {

                Boolean valid = true;
                if ( TextUtils.isEmpty(fullnameg) ) {
                    fullname.setError("Username is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(cnicg) ) {
                    cnic.setError("Contact is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(genderg) ) {
                    gender.setError("complainat district code is missing");
                    valid = false;
                }
                if ( TextUtils.isEmpty(guardiang) ) {
                    guardian.setError("Password is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(emailg) ) {
                    email.setError("complainant mail is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(districtg) ) {
                    district.setError("complainant name is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(ucg) ) {
                    uc.setError("complainant UC is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(addressg) ) {
                    address.setError("complainant guardian is missing");
                    valid = false;
                }
                if ( TextUtils.isEmpty(phoneg) ) {
                    phone.setError("complainant cnic is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(usernameg) ) {
                    username.setError("complainant address is missing");
                    valid = false;
                }


                if ( valid ) {
                    Responsemodel object=response.body();
                    if(object.getResponse()==1){
                        Toast.makeText(getApplicationContext(), object.getResponseMsg(), Toast.LENGTH_LONG).show();
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


    private void processdata(int user_id) {
        Call<pojo> processData= apiController.getInstance()
                .getapi()
                .showProfile(user_id);
        processData.enqueue(new Callback<pojo>() {
            @Override
            public void onResponse(Call<pojo> call, Response<pojo> response) {
                pojo object = response.body();
                if(object.getResponse()==1){
                    fullname.setText(object.getUserProfile().getComplainantName());
                    cnic.setText(object.getUserProfile().getComplainantCnic());
                    gender.setText(object.getUserProfile().getComplainantGender());
                    guardian.setText(object.getUserProfile().getComplainantGuardianName());
                    email.setText(object.getUserProfile().getComplainantEmail());
                    district.setText(object.getUserProfile().getComplainantDistrictName());
                    uc.setText(object.getUserProfile().getComplainantCouncil());
                    address.setText(object.getUserProfile().getComplainantAddress());
                    phone.setText(object.getUserProfile().getComplainantContact());
                    username.setText(object.getUserProfile().getUserName());
                    //avatar.setText(object.getUserProfile().getUserAvatar());

                }else{
                    Toast.makeText(getApplicationContext(), object.getResponseMsg(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<pojo> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });
    }
}