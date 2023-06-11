package com.example.mutiplerecyclerview;

import java.util.Date;
import java.util.List;

public class Day {
    private Date date;
    private List<Integer> data;

    Day(Date date, List<Integer> data) {
        this.date = date;
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public List<Integer> getData() {
        return data;
    }
}
