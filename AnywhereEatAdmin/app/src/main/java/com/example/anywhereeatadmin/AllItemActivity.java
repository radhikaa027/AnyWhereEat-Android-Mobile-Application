package com.example.anywhereeatadmin;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;
        import com.example.anywhereeatadmin.adapter.AddItemAdapter;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class AllItemActivity extends AppCompatActivity {

    private RecyclerView menuRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_item);

        menuRecyclerView = findViewById(R.id.MenuRecyclerView);

        List<String> menuFoodName = Arrays.asList("Burger", "Sandwich", "IceCream", "Tomato soup", "Sandwich", "SweetCorn soup");
        List<String> menuItemPrice = Arrays.asList("₹50", "₹60", "₹80", "₹90", "₹60", "₹90");
        List<Integer> menuImage = Arrays.asList(
                R.drawable.menu1,
                R.drawable.menu2,
                R.drawable.menu3,
                R.drawable.menu4,
                R.drawable.menu5,
                R.drawable.menu4
        );

        AddItemAdapter adapter = new AddItemAdapter(this, new ArrayList<>(menuFoodName), new ArrayList<>(menuItemPrice), new ArrayList<>(menuImage));
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        menuRecyclerView.setAdapter(adapter);

        ImageButton backButton = findViewById(R.id.BackButton);
        // Setting OnClickListener for back button (ImageButton)
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Navigate back to the previous activity
            }
        });
    }
}
