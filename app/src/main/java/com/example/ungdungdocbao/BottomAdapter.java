package com.example.ungdungdocbao;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BottomAdapter extends FragmentStatePagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();

    public BottomAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position); //tra ve item o vi tri
    }
    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public void  addF(Fragment fragment){
        mFragmentList.add(fragment);
    }
}
