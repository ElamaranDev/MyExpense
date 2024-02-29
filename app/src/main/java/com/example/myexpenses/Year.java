package com.example.myexpenses;

import androidx.annotation.NonNull;

public class Year {
    private String year;

    public Year(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @NonNull
    @Override
    public String toString() {
        return "Year{" +
                "year='" + year + '\'' +
                '}';
    }
}
