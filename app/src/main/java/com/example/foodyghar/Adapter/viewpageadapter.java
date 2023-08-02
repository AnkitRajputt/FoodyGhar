package com.example.foodyghar.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class viewpageadapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> arrayList = new ArrayList<>();
    ArrayList<String> StringarrayList = new ArrayList<>();

    public viewpageadapter(@NonNull FragmentManager fm) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    public void addFragment(Fragment fragment, String name) {
        arrayList.add(fragment);
        StringarrayList.add(name);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return StringarrayList.get(position);
    }
}
