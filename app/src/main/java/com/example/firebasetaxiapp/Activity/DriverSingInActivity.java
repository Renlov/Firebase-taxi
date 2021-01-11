package com.example.firebasetaxiapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebasetaxiapp.R;
import com.google.android.material.textfield.TextInputLayout;

public class DriverSingInActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;

    private Button loginSingUpButton;
    private TextView toggleLoginSingUpTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_sing_in);

        textInputEmail = findViewById(R.id.textInputEmail);
        textInputName = findViewById(R.id.textInputName);
        textInputPassword = findViewById(R.id.textInputPassword);
        textInputConfirmPassword = findViewById(R.id.textInputConfirmPassword);

        loginSingUpButton = findViewById(R.id.loginSingUpButton);
        toggleLoginSingUpTextView = findViewById(R.id.toggleLoginSingUpTextView);
    }

    private boolean validateEmail() {

        String emailInput = textInputEmail.getEditText().getText().toString();
        if(emailInput.isEmpty()) {
            textInputEmail.setError("Please input your email");
            return false;
        }
        else {
            textInputEmail.setError("");
            return true;
        }
    }

    private boolean validateName() {

        String nameInput = textInputName.getEditText().getText().toString();
        if(nameInput.isEmpty()) {
            textInputName.setError("Please input your name");
            return false;
        } else if (nameInput.length() > 15) {
            textInputName.setError("To more character");
            return false;
        }
        else {
            textInputName.setError("");
            return true;
        }
    }

    private boolean validatePassword() {

        String passwordInput = textInputPassword.getEditText().getText().toString();
        String confirmPasswordInput = textInputConfirmPassword.getEditText().getText().toString();

        if(passwordInput.isEmpty()) {
            textInputPassword.setError("Please input your name");
            return false;
        } else if (passwordInput.length() < 7) {
            textInputPassword.setError("Password should be harder");
            return false;
        } else if (!passwordInput.equals(confirmPasswordInput)) {
            textInputPassword.setError("Password do not match");
            return false;
        }
        else {
            textInputPassword.setError("");
            return true;
        }
    }


    public void loginSingUpUser(View view) {
        if(!validateEmail() | !validateName() | !validatePassword()) {
            return;
        }

        String userInput = "Email: " + textInputEmail.getEditText().getText().toString().trim() +
                "\n" + "Name: " + textInputName.getEditText().getText().toString().trim() +
                "\n" + "Password: " + textInputPassword.getEditText().getText().toString().trim();
        Toast.makeText(this, userInput, Toast.LENGTH_SHORT).show();
    }

    public void toggleLoginSingUp(View view) {
    }
}