package com.example.myexpenses;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView yearsRecView;
    private ArrayList<Year> yearsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView newText = findViewById(R.id.yearsText);
        newText.setText(R.string.year_title);

        yearsRecView = findViewById(R.id.yearsRecView);

        Button addButton = findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showAddYearDialog();
            }
        });
    }

    private void showAddYearDialog() {
        AddYearDialog addYearDialog = new AddYearDialog(this, new AddYearDialog.OnAddYearListener() {
            @Override
            public void onAddYear(String year) {
                addYearToList(year);
            }
        });
        addYearDialog.show();
    }

    private void addYearToList(String year) {
        yearsList.add(new Year(year));

        YearsRecViewAdapter adapter = new YearsRecViewAdapter();
        adapter.setYears(yearsList);

        yearsRecView.setAdapter(adapter);
        yearsRecView.setLayoutManager(new LinearLayoutManager(this));
    }
}
