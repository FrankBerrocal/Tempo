/**
 * Frank Berrocal Azofeifa
 * Final Project
 *
 * SODV3203 Mobile Application Development
 * Prof.  Ali Moussa
 * Bow Valley College
 *
 * April 2023
 */

package com.example.finalproject_fberrocal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {
    private final int mNumOfTabs;

    /**
     * pagerAdapter
     * @param fragmentManager
     * @param lifecycle
     * @param numOfTabs
     * object defined for visualization of fragments.
     */
    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, int numOfTabs) {
        super(fragmentManager, lifecycle);
        mNumOfTabs = numOfTabs;
    }

    /**
     * createFragment
     * @param position
     * @return names of the tabs or null.
     * Fragments are created in the pager.
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new fragment_payment();
            case 1:
                return new fragment_calculator();
            default:
                return null;
        }
    }

    /**
     * getItemCount
     * @return mNumOfTabs
     * indicates how many tabs have been included in the pager.
     */
    @Override
    public int getItemCount() {
        return mNumOfTabs;
    }
}
