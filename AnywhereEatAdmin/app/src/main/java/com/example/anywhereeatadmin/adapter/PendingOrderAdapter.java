package com.example.anywhereeatadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.anywhereeatadmin.R;

import java.util.ArrayList;


public class PendingOrderAdapter extends RecyclerView.Adapter<PendingOrderAdapter.PendingOrderViewHolder> {
    private ArrayList<String> customerNames;
    private ArrayList<String> quantity;
    private ArrayList<Integer> foodImage;
    private Context context;

    public PendingOrderAdapter(ArrayList<String> customerNames, ArrayList<String> quantity, ArrayList<Integer> foodImage, Context context) {
        this.customerNames = customerNames;
        this.quantity = quantity;
        this.foodImage = foodImage;
        this.context = context;
    }

    @NonNull
    @Override
    public PendingOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_orders_item, parent, false);
        return new PendingOrderViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingOrderViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return customerNames.size();
    }

    public class PendingOrderViewHolder extends RecyclerView.ViewHolder {
        private ImageView orderdfoodImage;
        private TextView customerName;
        private TextView pendingOrderQuantity;
        private TextView orderedAcceptTextView;
        private boolean isAccepted = false;

        public PendingOrderViewHolder(View itemView) {
            super(itemView);
            orderdfoodImage = itemView.findViewById(R.id.orderdFoodImage);
            customerName = itemView.findViewById(R.id.customerName);
            pendingOrderQuantity = itemView.findViewById(R.id.pendingOrderQuantity);
            orderedAcceptTextView = itemView.findViewById(R.id.orderedAcceptButton);
        }

        public void bind(final int position) {
            customerName.setText(customerNames.get(position));
            pendingOrderQuantity.setText(quantity.get(position));
            orderdfoodImage.setImageResource(foodImage.get(position));

            orderedAcceptTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isAccepted) {
                        orderedAcceptTextView.setText("Dispatched");
                        isAccepted = true;
                        showToast("Order is Accepted");
                    } else {
                        customerNames.remove(position);
                        notifyItemRemoved(position);
                        showToast("Order is Dispatched");
                    }
                }
            });
        }

        private void showToast(String message) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
}