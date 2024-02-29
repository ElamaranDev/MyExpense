package com.example.myexpenses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class YearsRecViewAdapter extends RecyclerView.Adapter<YearsRecViewAdapter.ViewHolder>
{
    private ArrayList<Year> years = new ArrayList<>();
    public YearsRecViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.years_recycler_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.yearButton.setText(years.get(position).getYear());
    }

    @Override
    public int getItemCount() {
        return years.size();
    }

    public void setYears(ArrayList<Year> years) {
        this.years = years;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private Button yearButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            yearButton = itemView.findViewById(R.id.year_card_button);
        }
    }
}