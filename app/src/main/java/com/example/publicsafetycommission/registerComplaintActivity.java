package com.example.publicsafetycommission;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class registerComplaintActivity extends AppCompatActivity {
    ImageView selectImage, selectVideo, selectAudio, selectDoc;
    private static final int PICK_IMAGE = 100;
    private static final int PICK_VIDEO = 100;
    private static final int PICKFILE_REQUEST_CODE =100;
    private static final int PICK_AUDIO =100;
    ImageView setImage;
    EditText comdistrict, compcategory, concilname, detail;
    Uri imageUri;
    Button add;
    TextView logout;
    SharedPreferences sharedPreferences;
    private static final  String SHARED_PREF_NAME = "myPref";
    private static final  String TOKEN = "myToken";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_complaint);

        selectImage = findViewById(R.id.selectimage);
        selectVideo = findViewById(R.id.selectvideo);
        selectAudio = findViewById(R.id.selectaudio);
        selectDoc = findViewById(R.id.selectdoc);
        comdistrict=findViewById(R.id.districtofcomp);
        compcategory=findViewById(R.id.categoryofcomp);
        concilname=findViewById(R.id.councilname);
        detail=findViewById(R.id.comdetail);
        add=findViewById(R.id.button2);
        logout=findViewById(R.id.logout);



        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String token = sharedPreferences.getString(TOKEN,null);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processdata(
                        comdistrict.getText().toString().trim(),
                        compcategory.getText().toString().trim(),
                        concilname.getText().toString().trim(),
                        detail.getText().toString().trim(), token);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(registerComplaintActivity.this,
                        LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });
        selectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });
        selectVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickVideo();
            }
        });
        selectAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickAudio();
            }
        });
        selectDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickDoc();
            }
        });
    }


    private void pickDoc() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(intent, "Select Image from here..."), PICKFILE_REQUEST_CODE);
    }

    private void pickAudio() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_AUDIO);
    }

    private void pickVideo() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_VIDEO);
    }

    private void pickImage() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            setImage.setImageURI(imageUri);
        }
        if (resultCode == RESULT_OK && requestCode == PICK_VIDEO) {
            setImage.setImageResource(R.drawable.video);
        }
    }
    public  void processdata(String user_district, String user_council, String comp_category, String comp_Detail, String tokenn)
    {
        Call<responsemodel> call= apiController.getInstance()
                .getapi()
                .getcompRegister(user_district, user_council, comp_category,comp_Detail, tokenn);

        call.enqueue(new Callback<responsemodel>() {
            @Override
            public void onResponse(Call<responsemodel> call, Response<responsemodel> response) {
                Boolean valid = true;
                if ( TextUtils.isEmpty(user_district) ) {
                    comdistrict.setError("complaint district is missing");
                    valid = false;
                }

                if ( TextUtils.isEmpty(user_council) ) {
                    concilname.setError("Password is missing");
                    valid = false;
                }
                if ( TextUtils.isEmpty(comp_category) ) {
                    compcategory.setError("Password is missing");
                    valid = false;
                }
                if ( TextUtils.isEmpty(comp_Detail) ) {
                    detail.setError("Password is missing");
                    valid = false;
                }

                if ( valid ) {
                    responsemodel object=response.body();

                    Toast.makeText(getApplicationContext(), object.getMessage(), Toast.LENGTH_LONG).show();

                }
            }

            @Override
            public void onFailure(Call<responsemodel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
            }
        });



    }

}