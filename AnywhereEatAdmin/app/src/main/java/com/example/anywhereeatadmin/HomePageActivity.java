package com.example.anywhereeatadmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        CardView cardView1 = findViewById(R.id.AddMenuCardView);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cardView click
                Intent intent = new Intent(HomePageActivity.this, AddItemActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView2 = findViewById(R.id.allItemMenuCardView);

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cardView click
                Intent intent = new Intent(HomePageActivity.this, AllItemActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView3 = findViewById(R.id.outForDeliveryButton);

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cardView click
                Intent intent = new Intent(HomePageActivity.this, OutForDeliveryActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView4 = findViewById(R.id.profile);

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cardView click
                Intent intent = new Intent(HomePageActivity.this, AdminProfileActivity.class);
                startActivity(intent);
            }
        });
        CardView cardView5 = findViewById(R.id.pendingOrderCartView);

        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cardView click
                Intent intent = new Intent(HomePageActivity.this, PendingOrderActivity.class);
                startActivity(intent);
            }
        });
        TextView pendingOrder = findViewById(R.id.pendingOrderTextView);
        pendingOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle signup textview click
                Intent intent = new Intent(HomePageActivity.this, PendingOrderActivity.class);
                startActivity(intent);
            }
        });

        CardView cardView6 = findViewById(R.id.logoutCardView);

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle cardView click
                Intent intent = new Intent(HomePageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}