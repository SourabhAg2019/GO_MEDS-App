package com.example.second;

public class vertical_recycleview {
    private String address_rr;
    private int days_ago;
    private String type;

    public vertical_recycleview(String address_rr, int days_ago, String type) {
        this.address_rr = address_rr;
        this.days_ago = days_ago;
        this.type = type;
    }

    public String getAddress_rr() {
        return address_rr;
    }

    public int getDays_ago() {
        return days_ago;
    }

    public String getType() {
        return type;
    }
}
