package com.example.anywhereeatadmin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminProfileActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText addressEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText passwordEditText;
    private TextView editButton;
    private boolean isEnable = false;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

        nameEditText = findViewById(R.id.name);
        addressEditText = findViewById(R.id.address);
        emailEditText = findViewById(R.id.email);
        phoneEditText = findViewById(R.id.phone);
        passwordEditText = findViewById(R.id.password);
        editButton = findViewById(R.id.editButton);

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nameEditText.setEnabled(false);
        addressEditText.setEnabled(false);
        emailEditText.setEnabled(false);
        phoneEditText.setEnabled(false);
        passwordEditText.setEnabled(false);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isEnable = !isEnable;
                nameEditText.setEnabled(isEnable);
                addressEditText.setEnabled(isEnable);
                emailEditText.setEnabled(isEnable);
                phoneEditText.setEnabled(isEnable);
                passwordEditText.setEnabled(isEnable);
                if (isEnable) {
                    nameEditText.requestFocus();
                }
            }
        });
    }
}
