package com.example.mutiplerecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayViewHolder> {
    private List<Day> days;

    public DayAdapter(List<Day> days) {
        this.days = days;
    }

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
        return new DayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        Day day = days.get(position);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd", Locale.getDefault());
        String dateString = formatter.format(day.getDate());

        if (position == 0) {
            holder.tvDay.setVisibility(View.GONE);  // Make the date TextView invisible for "Today"
        } else {
            holder.tvDay.setVisibility(View.VISIBLE); // Ensure the date TextView is visible for other days
            holder.tvDay.setText(dateString);
        }

        holder.llData.removeAllViews();
        for (Integer data : day.getData()) {
            TextView tvData = new TextView(holder.llData.getContext());
            tvData.setText(String.valueOf(data));
            holder.llData.addView(tvData);
        }
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    static class DayViewHolder extends RecyclerView.ViewHolder {
        TextView tvDay;
        LinearLayout llData;

        DayViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tv_day);
            llData = itemView.findViewById(R.id.ll_data);
        }
    }
}

