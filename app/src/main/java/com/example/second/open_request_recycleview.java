package com.example.second;

import android.widget.ImageView;
import android.widget.TextView;

public class open_request_recycleview {

    private String request_profile_name;
    private int days_ago;
    private String type;

    public open_request_recycleview(String request_profile_name, int days_ago, String type) {
        this.request_profile_name = request_profile_name;
        this.days_ago = days_ago;
        this.type = type;
    }

    public String getRequest_profile_name() {
        return request_profile_name;
    }

    public int getDays_ago() {
        return days_ago;
    }

    public String getType() {
        return type;
    }
}
