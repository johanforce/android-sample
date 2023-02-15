package com.jarvis.amlich.presentation.ui.calendar.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SlideAdapter extends FragmentPagerAdapter {
    private int mCurrentPosition = -1;
    private List<Fragment> listFragment;

    public SlideAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.listFragment = new ArrayList<>();
    }


    public void addData(List<Fragment> listFragment) {
        if (listFragment != null) {
            this.listFragment.clear();
            this.listFragment.addAll(listFragment);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return this.listFragment.get(position);
    }

    @Override
    public int getCount() {
        return this.listFragment.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);

        if (position != mCurrentPosition && container instanceof CustomViewPager) {
            Fragment fragment = (Fragment) object;
            CustomViewPager pager = (CustomViewPager) container;

            if (fragment != null && fragment.getView() != null) {
                mCurrentPosition = position;
                pager.measureCurrentView(fragment.getView());
            }
        }
    }
}