package com.example.android.newsapp_retrofit.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android.newsapp_retrofit.Fragment.EntertainmentFragment;
import com.example.android.newsapp_retrofit.Fragment.HealthFragment;
import com.example.android.newsapp_retrofit.Fragment.HomeFragment;
import com.example.android.newsapp_retrofit.Fragment.ScienceFragment;
import com.example.android.newsapp_retrofit.Fragment.SportsFragment;
import com.example.android.newsapp_retrofit.Fragment.TechnologyFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabCount;
    public PagerAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();

            case 1:
                return new SportsFragment();

            case 2:
                return new HealthFragment();

            case 3:
                return new ScienceFragment();

            case 4:
                return new EntertainmentFragment();

            case 5:
                return new TechnologyFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
