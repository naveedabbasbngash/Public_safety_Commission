package com.example.publicsafetycommission;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PassReset extends AppCompatActivity {
    EditText user_name;
    Button reset;
    DBHelperClass DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_reset);
        user_name=findViewById(R.id.btn_username);
        reset=findViewById(R.id.bt_reset);
        DB= new DBHelperClass(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotPasswordDialog();
                //Toast.makeText(Login.this, "Coming soon...", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void forgotPasswordDialog() {
    }
}