package com.example.anywhereeatadmin;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText signupEmail, signupPassword;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signupButton = findViewById(R.id.signupBtn);
        loginRedirectText = findViewById(R.id.textLogin);
        signupEmail = findViewById(R.id.userEdt);
        signupPassword = findViewById(R.id.passEdt);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    database = FirebaseDatabase.getInstance();
                    reference = database.getReference("users");

                    String email = signupEmail.getText().toString();
                    String encodedEmail = encodeEmail(email); // Encode the email
                    String password = signupPassword.getText().toString();

                    HelperClass helperClass = new HelperClass(email, password);
                    reference.child(encodedEmail).setValue(helperClass);

                    Toast.makeText(SignUpActivity.this, "You have Signup Successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    // Function to encode the email address
    private String encodeEmail(String email) {
        return email.replace(".", ",");
    }

    // Function to validate email address and decode it
    private boolean validateFields() {
        String email = signupEmail.getText().toString().trim();
        String decodedEmail = decodeEmail(email); // Decode the email
        String password = signupPassword.getText().toString().trim();

        if (TextUtils.isEmpty(decodedEmail) || !Patterns.EMAIL_ADDRESS.matcher(decodedEmail).matches()) {
            signupEmail.setError("Please enter a valid email address");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            signupPassword.setError("Password cannot be empty");
            return false;
        }

        return true;
    }

    // Function to decode the email address
    private String decodeEmail(String encodedEmail) {
        return encodedEmail.replace(",", ".");
    }
}
