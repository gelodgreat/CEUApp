package com.gelo.ceuapp;

/**
 * Created by ANDREW on 3/18/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                umali_developer tab1 = new umali_developer();
                return tab1;
            case 1:
                hamili_developer tab2 = new hamili_developer();
                return tab2;
            case 2:
                wu_developer tab3 = new wu_developer();
                return tab3;
            case 3:
                tan_developer tab4 = new tan_developer();
                return tab4;
            case 4:
                buenaventura_developer tab5 = new buenaventura_developer();
                return tab5;
            case 5:
                viril_developer tab6 = new viril_developer();
                return tab6;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}