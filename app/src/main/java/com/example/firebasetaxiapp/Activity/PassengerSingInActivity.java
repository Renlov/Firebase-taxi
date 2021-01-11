package com.example.firebasetaxiapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firebasetaxiapp.R;
import com.google.android.material.textfield.TextInputLayout;

public class PassengerSingInActivity extends AppCompatActivity {

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;

    private Button loginSingUpButton;
    private TextView toggleLoginSingUpTextView;

    private boolean isLoginModeActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_sing_in);

        textInputEmail = findViewById(R.id.textInputEmailPassenger);
        textInputName = findViewById(R.id.textInputNamePassenger);
        textInputPassword = findViewById(R.id.textInputPasswordPassenger);
        textInputConfirmPassword = findViewById(R.id.textInputConfirmPasswordPassenger);

        loginSingUpButton = findViewById(R.id.loginSingUpButtonPassenger);
        toggleLoginSingUpTextView = findViewById(R.id.toggleLoginSingUpTextViewPassenger);
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


    public void loginSingUpPassenger(View view) {
        if(!validateEmail() | !validateName() | !validatePassword()) {
            return;
        }

        String userInput = "Email: " + textInputEmail.getEditText().getText().toString().trim() +
                "\n" + "Name: " + textInputName.getEditText().getText().toString().trim() +
                "\n" + "Password: " + textInputPassword.getEditText().getText().toString().trim();
        Toast.makeText(this, userInput, Toast.LENGTH_SHORT).show();
    }

    public void toggleLoginSingUpPassenger(View view) {

        if(isLoginModeActive) {
            isLoginModeActive = false;
            loginSingUpButton.setText("Sing Up");
            toggleLoginSingUpTextView.setText("Log In");
            textInputConfirmPassword.setVisibility(View.VISIBLE);
        } else {
            isLoginModeActive = true;
            loginSingUpButton.setText("Log In");
            toggleLoginSingUpTextView.setText("Sing Up");
            textInputConfirmPassword.setVisibility(View.GONE);
        }
    }

}