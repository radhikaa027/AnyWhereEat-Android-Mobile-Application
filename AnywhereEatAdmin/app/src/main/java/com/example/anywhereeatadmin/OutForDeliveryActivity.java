package com.example.anywhereeatadmin;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.anywhereeatadmin.adapter.DeliveryAdapter;
import java.util.ArrayList;

public class OutForDeliveryActivity extends AppCompatActivity {
    private RecyclerView deliveryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_for_delivery);

        deliveryRecyclerView = findViewById(R.id.deliveryRecyclerView);

        ArrayList<String> customerName = new ArrayList<>();
        customerName.add("John Doe");
        customerName.add("Jane Smith");
        customerName.add("Mike Johnson");

        ArrayList<String> moneyStatus = new ArrayList<>();
        moneyStatus.add("received");
        moneyStatus.add("notReceived");
        moneyStatus.add("Pending");

        DeliveryAdapter adapter = new DeliveryAdapter(customerName, moneyStatus);
        deliveryRecyclerView.setAdapter(adapter);
        deliveryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageButton backButton = findViewById(R.id.backButton);
        // Setting OnClickListener for back button (ImageButton)
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Navigate back to the previous activity
            }
        });

    }
}
