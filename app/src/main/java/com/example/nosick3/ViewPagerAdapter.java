package com.example.nosick3;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new FragmentOne();
            case 1: return new FragmentTwo();
            case 2: return new FragmentThree();
            case 3: return new FragmentFour();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
