package com.example.submission2.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.submission2.fragment.MovieFragment;
import com.example.submission2.fragment.TvShowFragment;
//import com.example.submission2.fragment.TvShowFragment;

public class PageAdapter extends FragmentStatePagerAdapter {

    private String[] title = new String[]{"Movie", "TV Show"};
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MovieFragment();
            case 1:
                return new TvShowFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
