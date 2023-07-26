package com.example.second;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> f_list = new ArrayList<>();
    private final ArrayList<String> f_title = new ArrayList<>();

    public VPAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public Fragment getItem(int position) {
        return f_list.get(position);
    }

    @Override
    public int getCount() {
        return f_list.size();
    }

    public void addFragment(Fragment fragment, String title) {
        f_list.add(fragment);
        f_title.add(title);
    }

    public CharSequence getPageTitle(int position) {
        return f_title.get(position);
    }



}
