package com.gelo.ceuapp;

/*
  Created by ANDREW on 3/18/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gelo.ceuapp.aboutfolder.buenaventura_developer;
import com.gelo.ceuapp.aboutfolder.hamili_developer;
import com.gelo.ceuapp.aboutfolder.tan_developer;
import com.gelo.ceuapp.aboutfolder.umali_developer;
import com.gelo.ceuapp.aboutfolder.viril_developer;
import com.gelo.ceuapp.aboutfolder.wu_developer;

class PagerAdapter extends FragmentStatePagerAdapter {
    private final int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new umali_developer();
            case 1:
                return new hamili_developer();
            case 2:
                return new wu_developer();
            case 3:
                return new tan_developer();
            case 4:
                return new buenaventura_developer();
            case 5:
                return new viril_developer();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}