package com.example.modern_ui_splash_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class user_profile extends AppCompatActivity {
    TextInputLayout fullName,email,phoneNo,password;
    TextView fullNameLabel,usernameLabel;

    String username,name,upassword,phone,uemail;

    DatabaseReference reference;


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

        reference = FirebaseDatabase.getInstance().getReference("users");


        showAllUserData();

    }

    private void showAllUserData() {
        Intent intent = getIntent();

        username = intent.getStringExtra("username");
        name = intent.getStringExtra("name");
        phone = intent.getStringExtra("phone");
        upassword = intent.getStringExtra("pass");
        uemail = intent.getStringExtra("email");

        fullNameLabel.setText(name);
        usernameLabel.setText(username);
        fullName.getEditText().setText(name);
        email.getEditText().setText(uemail);
        phoneNo.getEditText().setText(phone);
        password.getEditText().setText(upassword);
    }
    public void update(View view) {
        if(isNameChanged() || isPasswordChanged()||isEmailChange()){
            Toast.makeText(this, "Data has been updated. ", Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(this,"Data is same and can not be updated",Toast.LENGTH_SHORT).show();


    }

    private boolean isPasswordChanged(){
        if(!upassword.equals(password.getEditText().getText().toString()))
        {
            reference.child(username).child("pass").setValue(password.getEditText().getText().toString());
            upassword=password.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }
    }
    private boolean isNameChanged(){
        if(!name.equals(fullName.getEditText().getText().toString())){
            reference.child(username).child("name").setValue(fullName.getEditText().getText().toString());
            name=fullName.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }

    }
    private boolean isEmailChange(){
        if(!uemail.equals(email.getEditText().getText().toString())){
            reference.child(username).child("email").setValue(email.getEditText().getText().toString());
            uemail=email.getEditText().getText().toString();
            return true;
        }else{
            return false;
        }

    }


}
