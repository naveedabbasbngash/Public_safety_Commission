package com.example.publicsafetycommission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
    ImageView registerComplaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        registerComplaint=findViewById(R.id.registerComplaint);

        registerComplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(HomeActivity.this, registerComplaintActivity.class);
                startActivity(myIntent);
            }
        });


    }



}