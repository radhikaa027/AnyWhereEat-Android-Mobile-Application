package com.example.anywhereeatadmin.adapter;



import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.anywhereeatadmin.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder> {
    private ArrayList<String> customerNames;
    private ArrayList<String> moneyStatus;
    private Context context;

    public DeliveryAdapter(ArrayList<String> customerNames, ArrayList<String> moneyStatus) {
        this.context = context;
        this.customerNames = customerNames;
        this.moneyStatus = moneyStatus;
    }

    @NonNull
    @Override
    public DeliveryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_item, parent, false);
        return new DeliveryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return customerNames.size();
    }

    public class DeliveryViewHolder extends RecyclerView.ViewHolder {
        private TextView customerName;
        private TextView statusMoney;
        private View statusColor;

        public DeliveryViewHolder(View itemView) {
            super(itemView);
            customerName = itemView.findViewById(R.id.customerName);
            statusMoney = itemView.findViewById(R.id.statusMoney);
            statusColor = itemView.findViewById(R.id.StatusColor);
        }

        public void bind(int position) {
            customerName.setText(customerNames.get(position));
            statusMoney.setText(moneyStatus.get(position));
            Map<String, Integer> colorMap = new HashMap<>();
            colorMap.put("received", Color.GREEN);
            colorMap.put("not Received", Color.RED);
            colorMap.put("Pending", Color.GRAY);
            Integer color = colorMap.get(moneyStatus.get(position));
            if (color != null) {
                statusMoney.setTextColor(color);
                statusColor.setBackgroundTintList(ColorStateList.valueOf(color));
            } else {
                statusMoney.setTextColor(Color.BLACK);
                statusColor.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
            }
        }
    }
}
