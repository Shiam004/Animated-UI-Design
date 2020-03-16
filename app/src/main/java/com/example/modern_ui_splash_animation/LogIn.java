package com.example.modern_ui_splash_animation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.BoringLayout;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

import com.agrawalsuneet.dotsloader.loaders.AllianceLoader;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends AppCompatActivity {

    Button login_btn,sign_up;
    TextInputLayout username,password;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_log_in);




        progressBar = findViewById(R.id.progress_bar);

        progressBar.setVisibility(View.GONE);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        sign_up = findViewById(R.id.sign_up);





        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this,SignUp.class);
                startActivity(intent);

            }
        });



    }


    private Boolean validateUsername(){
        String val = username.getEditText().getText().toString();

        if(val.isEmpty()){
            username.setError("Field cannot be empty");
            return false;
        }else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }


    }
    private Boolean validatePassword(){
        String val= password.getEditText().getText().toString();
        if(val.isEmpty()) {
            username.setError("Field cannot be empty");
            return false;

        }else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
            }

        }




    public void LogIn(View view) {

        progressBar.setVisibility(View.VISIBLE);

        if (!validatePassword()| !validateUsername()){
            return;
        }
        else {
            isUser();
        }



    }


    private void isUser() {
        final String userEnterdUsername = username.getEditText().getText().toString().trim();
        final String userEnterdPassword = password.getEditText().getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("username").equalTo(userEnterdUsername);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){

                    username.setError(null);
                    username.setErrorEnabled(false);

                    String passwordFromDB = dataSnapshot.child(userEnterdUsername).child("pass").getValue(String.class);

                    if(passwordFromDB.equals((userEnterdPassword))){
                        password.setError(null);
                        password.setErrorEnabled(false);


                        String nameFromDB = dataSnapshot.child(userEnterdUsername).child("name").getValue(String.class);
                        String usernameFromDB = dataSnapshot.child(userEnterdUsername).child("username").getValue(String.class);
                        String phonNoFromDB = dataSnapshot.child(userEnterdUsername).child("phone").getValue(String.class);
                        String emailFromDB = dataSnapshot.child(userEnterdUsername).child("email").getValue(String.class);

                        Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("phone",phonNoFromDB);
                        intent.putExtra("email",emailFromDB);
                        intent.putExtra("pass",passwordFromDB);

                        startActivity(intent);
                    }
                    else {
                        password.setError("Wrong Password");
                        password.requestFocus();
                    }
                }
                else
                {
                    username.setError("No such user exist");
                    username.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
