package com.distinct.tamyg.twitterclient.main.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tamyg on 20/06/16.
 */
public class MainSectionsPageAdapter extends FragmentPagerAdapter {
    private String[] titles;
    private Fragment[] fragments;

    public MainSectionsPageAdapter(FragmentManager fm, String[] titles, Fragment[] fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments[position];
    }

    @Override
    public int getCount() {
        return this.fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.titles[position];
    }
}
