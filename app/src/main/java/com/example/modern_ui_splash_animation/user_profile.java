package com.example.modern_ui_splash_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class user_profile extends AppCompatActivity {
    TextInputLayout fullName,email,phoneNo,password;
    TextView fullNameLabel,usernameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_user_profile);



        //Hooks
        fullName = findViewById(R.id.full_name_profile);
        email = findViewById(R.id.email_profile);
        phoneNo = findViewById(R.id.phone_no_profile);
        password = findViewById(R.id.password_profile);
        fullNameLabel = findViewById(R.id.fullname_field);
        usernameLabel = findViewById(R.id.username_field);


        showAllUserData();

    }

    private void showAllUserData() {
        Intent intent = getIntent();

        String username = intent.getStringExtra("username");
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        String upassword = intent.getStringExtra("pass");
        String uemail = intent.getStringExtra("email");

        fullNameLabel.setText(name);
        usernameLabel.setText(username);
        fullName.getEditText().setText(name);
        email.getEditText().setText(uemail);
        phoneNo.getEditText().setText(phone);
        password.getEditText().setText(upassword);
    }
}
