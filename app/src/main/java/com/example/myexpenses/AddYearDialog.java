package com.example.myexpenses;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

public class AddYearDialog  extends Dialog {
    private EditText yearEditText;
    private final OnAddYearListener onAddYearListener;

    public interface OnAddYearListener
    {
        void onAddYear(String year);
    }
    public AddYearDialog(@NonNull Context context, OnAddYearListener onAddYearListener)
    {
        super(context);
        this.onAddYearListener = onAddYearListener;
    }

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_year);
        yearEditText = findViewById(R.id.yearEditText);
        Button addYearButton = findViewById(R.id.addButton);

        addYearButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                String year = yearEditText.getText().toString().trim();
                if(!year.isEmpty())
                {
                    onAddYearListener.onAddYear(year);
                    dismiss();
                }
            }
        });
    }
}
