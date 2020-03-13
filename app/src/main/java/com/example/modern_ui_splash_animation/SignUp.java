package com.example.modern_ui_splash_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    TextInputLayout Name, Username,Email,Phone,Pass;

    Button login;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sign_up);


        Name = findViewById(R.id.regName);
        Username = findViewById(R.id.regUserName);
        Email = findViewById(R.id.regEmail);
        Phone = findViewById(R.id.regPhone);
        Pass = findViewById(R.id.regPass);

        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this,LogIn.class);
                startActivity(intent);
            }
        });



    }
    private Boolean validateName() {
        String val = Name.getEditText().getText().toString();

        if (val.isEmpty()) {
            Name.setError("Field cannot be empty");
            return false;
        } else {
            Name.setError(null);
            Name.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUsername() {
        String val = Username.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()) {
            Username.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 15) {
            Username.setError("Username too long");
            return false;
        }  else {
            Username.setError(null);
            Username.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateEmail() {
        String val = Email.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            Email.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            Email.setError("Invalid email address");
            return false;
        } else {
            Email.setError(null);
            Email.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhoneNo() {
        String val = Phone.getEditText().getText().toString();

        if (val.isEmpty()) {
            Phone.setError("Field cannot be empty");
            return false;
        } else {
            Phone.setError(null);
            Phone.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword() {
        String val = Pass.getEditText().getText().toString();
        String passwordVal =
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}";

        if (val.isEmpty()) {
            Pass.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            Pass.setError("Password is too weak");
            return false;
        } else {
            Pass.setError(null);
            Pass.setErrorEnabled(false);
            return true;
        }
    }

    //This function will execute when user click on Register Button
    public void registerUser(View view) {

        if(!validateName() | !validatePassword() | !validatePhoneNo() | !validateEmail() | !validateUsername()){
            return;
        }

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");

        String name = Name.getEditText().getText().toString();
        String username = Username.getEditText().getText().toString();
        String email = Email.getEditText().getText().toString();
        String phone = Phone.getEditText().getText().toString();
        String pass = Pass.getEditText().getText().toString();


        Intent intent = new Intent(getApplicationContext(),OTP_Verification.class);
        intent.putExtra("phone",phone);
        intent.putExtra("name",name);
        intent.putExtra("username",username);
        intent.putExtra("email",email);
        intent.putExtra("pass",pass);
        startActivity(intent);
        //storing Data
        //UserHelper userHelper = new UserHelper(name,username,email,phone,pass);
        //reference.child(username).setValue(userHelper);


      /*  Intent intent = new Intent(SignUp.this,LogIn.class);
        startActivity(intent);
        finish(); */

    }


}
