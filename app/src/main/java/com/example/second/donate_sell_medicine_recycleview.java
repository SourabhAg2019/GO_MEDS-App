package com.example.second;

public class donate_sell_medicine_recycleview {
    private String medicine_name;
    private int no_pills;

    public String getMedicine_name() {
        return medicine_name;
    }

    public int getNo_pills() {
        return no_pills;
    }


    public donate_sell_medicine_recycleview(String name, int pills, int rs) {
        this.medicine_name = name;
        this.no_pills = pills;
    }
}
