package com.example.modern_ui_splash_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class header extends AppCompatActivity {

    TextView fullNameLabel,usernameLabel;
    String username,name;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);


        fullNameLabel = findViewById(R.id.name);
        usernameLabel = findViewById(R.id.username);
        reference = FirebaseDatabase.getInstance().getReference("users");


        showAllUserData();


    }

    private void showAllUserData() {

        Intent intent = getIntent();
        username = intent.getStringExtra("username");
        name = intent.getStringExtra("name");

        fullNameLabel.setText(name);
        usernameLabel.setText(username);


    }
}
