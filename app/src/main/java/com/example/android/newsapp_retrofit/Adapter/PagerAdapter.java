package com.example.android.newsapp_retrofit.Adapter;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.android.newsapp_retrofit.Fragment.NewsFragment;

public class PagerAdapter extends FragmentPagerAdapter {


    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle =new Bundle();
        bundle.putString("category", getCategoryList()[position]);
        Fragment fr = new NewsFragment();
        fr.setArguments(bundle);
        return fr;
    }

    @Override
    public int getCount() {
        return getCategoryList().length;
    }

    private String[] getCategoryList() {
        return new String[]{null, "sports", "health", "science", "entertainment", "technology"};
    }
}

