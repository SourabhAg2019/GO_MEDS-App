package com.example.second;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class raise_request_fragment extends Fragment {

    RecyclerView recyclerView_rr2;
    ArrayList<vertical_recycleview> arr_vrr;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_raise_request_fragment, container, false);
        arr_vrr = new ArrayList<>();

        arr_vrr.add(new vertical_recycleview("Near me",6,"Medicine"));
        arr_vrr.add(new vertical_recycleview("Near me",5,"Medicine"));
        arr_vrr.add(new vertical_recycleview("Near me",4,"Medicine"));
        arr_vrr.add(new vertical_recycleview("Near me",3,"Medicine"));
        arr_vrr.add(new vertical_recycleview("Near me",2,"Medicine"));
        arr_vrr.add(new vertical_recycleview("Near me",1,"Medicine"));
        arr_vrr.add(new vertical_recycleview("Near me",0,"Medicine"));

        recyclerView_rr2 = view.findViewById(R.id.recyclerView_rr2);
        recyclerView_rr2.setHasFixedSize(true);
        recyclerView_rr2.setLayoutManager(new LinearLayoutManager(getContext()));

        vertical_recycleview_rr_adapter vrra = new vertical_recycleview_rr_adapter(arr_vrr);
        recyclerView_rr2.setAdapter(vrra);

        return view;
    }
}