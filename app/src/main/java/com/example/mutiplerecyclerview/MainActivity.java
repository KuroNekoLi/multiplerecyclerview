package com.example.mutiplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private List<Integer> today;
    private List<Integer> tomorrow;
    private List<Integer> theDayAfterTomorrow;
    private RecyclerView rvDay;
    private DayAdapter dayAdapter;
    private List<Day> days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();
        Date todayDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrowDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date dayAfterTomorrowDate = calendar.getTime();

        today = new ArrayList<>();
        today.add(1);
        today.add(2);
        today.add(3);

        tomorrow = new ArrayList<>();
        tomorrow.add(4);
        tomorrow.add(5);
        tomorrow.add(6);

        theDayAfterTomorrow = new ArrayList<>();
        theDayAfterTomorrow.add(7);
        theDayAfterTomorrow.add(8);
        theDayAfterTomorrow.add(9);

        days = new ArrayList<>();
        days.add(new Day(todayDate, today));
        days.add(new Day(tomorrowDate, tomorrow));
        days.add(new Day(dayAfterTomorrowDate, theDayAfterTomorrow));

        rvDay = findViewById(R.id.rv_day);
        rvDay.setLayoutManager(new LinearLayoutManager(this));
        dayAdapter = new DayAdapter(days);
        rvDay.setAdapter(dayAdapter);
    }
}