package com.example.nosick3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CovidViewPager extends FragmentPagerAdapter {

    public CovidViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new CovidFragment1();
            case 1: return new CovidFragment2();
            case 2: return new CovidFragment3();

        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
