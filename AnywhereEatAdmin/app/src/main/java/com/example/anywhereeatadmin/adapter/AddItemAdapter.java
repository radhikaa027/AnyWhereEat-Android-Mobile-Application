package com.example.anywhereeatadmin.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anywhereeatadmin.AllItemActivity;
import com.example.anywhereeatadmin.R;

import java.util.ArrayList;

public class AddItemAdapter extends RecyclerView.Adapter<AddItemAdapter.AddItemViewHolder> {
    private ArrayList<String> MenuItemName;
    private ArrayList<String> MenuItemPrice;
    private ArrayList<Integer> MenuItemImage;
    private int[] itemQuantities;

    public AddItemAdapter(AllItemActivity allItemActivity, ArrayList<String> menuItemName, ArrayList<String> menuItemPrice, ArrayList<Integer> menuItemImage) {
        MenuItemName = menuItemName;
        MenuItemPrice = menuItemPrice;
        MenuItemImage = menuItemImage;
        itemQuantities = new int[MenuItemName.size()];
    }

    @NonNull
    @Override
    public AddItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_item, parent, false);
        return new AddItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AddItemViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return MenuItemName.size();
    }

    public class AddItemViewHolder extends RecyclerView.ViewHolder {
        private TextView foodNameTextView;
        private TextView priceTextView;
        private ImageView foodImageView;
        private TextView quantityTextView;
        private View minusButton;
        private View deleteButton;
        private View plusButton;

        public AddItemViewHolder(View itemView) {
            super(itemView);
            foodNameTextView = itemView.findViewById(R.id.foodnameTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            quantityTextView = itemView.findViewById(R.id.quantityTextView);
            minusButton = itemView.findViewById(R.id.minusButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            plusButton = itemView.findViewById(R.id.plusButton);
        }

        public void bind(final int position) {
            final int quantity = itemQuantities[position];
            foodNameTextView.setText(MenuItemName.get(position));
            priceTextView.setText(MenuItemPrice.get(position));
            foodImageView.setImageResource(MenuItemImage.get(position));
            quantityTextView.setText(String.valueOf(quantity));

            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    decreaseQuantity(position);
                }
            });

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteQuantity(position);
                }
            });

            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    increaseQuantity(position);
                }
            });
        }

        private void increaseQuantity(int position) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++;
                quantityTextView.setText(String.valueOf(itemQuantities[position]));
            }
        }

        private void decreaseQuantity(int position) {
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--;
                quantityTextView.setText(String.valueOf(itemQuantities[position]));
            }
        }

        private void deleteQuantity(int position) {
            MenuItemName.remove(position);
            MenuItemPrice.remove(position);
            MenuItemImage.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, MenuItemName.size());
        }
    }
}
