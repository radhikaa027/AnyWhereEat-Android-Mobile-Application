package com.example.project162.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.project162.Activity.BaseActivity;
import com.example.project162.R;
import com.example.project162.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends BaseActivity implements View.OnClickListener {
    ActivitySignupBinding binding;
Button bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
        bb=findViewById(R.id.Buttonoo);
        bb.setOnClickListener(this);
    }

    private void setVariable() {
        binding.signupBtn.setOnClickListener(v -> {
            String email = binding.userEdt.getText().toString();
            String password = binding.passEdt.getText().toString();

            if (password.length() < 6) {
                Toast.makeText(SignupActivity.this, "Your password must be 6 characters long", Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, task -> {
                if (task.isSuccessful()) {
                    String userId = mAuth.getCurrentUser().getUid();
                    DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference().child("users");
                    usersRef.child(userId).child("email").setValue(email);
                    // You can store additional user data here if needed
                    startActivity(new Intent(SignupActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(SignupActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    @Override
    public void onClick(View v) {
        Intent kk=new Intent(this,LoginActivity.class);
        startActivity(kk);

    }
}
