package com.example.anywhereeatadmin;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anywhereeatadmin.adapter.PendingOrderAdapter;

import java.util.ArrayList;

public class PendingOrderActivity extends AppCompatActivity {
    private RecyclerView pendingOrderRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_order);

        pendingOrderRecyclerView = findViewById(R.id.pendingOrderRecyclerView);
        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ArrayList<String> orderedcustomerName = new ArrayList<>();
        orderedcustomerName.add("Rakesh");
        orderedcustomerName.add("Gopal");
        orderedcustomerName.add("Anshika");

        ArrayList<String> orderedQuantity = new ArrayList<>();
        orderedQuantity.add("8");
        orderedQuantity.add("6");
        orderedQuantity.add("5");

        ArrayList<Integer> orderedFoodImage = new ArrayList<>();
        orderedFoodImage.add(R.drawable.menu1);
        orderedFoodImage.add(R.drawable.menu2);
        orderedFoodImage.add(R.drawable.menu3);

        PendingOrderAdapter adapter = new PendingOrderAdapter(orderedcustomerName, orderedQuantity, orderedFoodImage, this);
        pendingOrderRecyclerView.setAdapter(adapter);
        pendingOrderRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
