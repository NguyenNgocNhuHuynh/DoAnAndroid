package com.example.ungdungdocbao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class FirstFragment extends Fragment {
    private TabLayout tabLayout;
    NavigationView nav;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    Toolbar toolbar;
    private ViewPager firstViewPager;

    public FirstFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.first_fragment, container, false);

        firstViewPager = (ViewPager) rootView.findViewById(R.id.viewpage_content);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(firstViewPager);

        setupViewPager(firstViewPager);
        nav = (NavigationView)rootView.findViewById(R.id.nav);
        drawerLayout = (DrawerLayout)rootView.findViewById(R.id.drawer);
        toolbar = (Toolbar)rootView.findViewById(R.id.toolbar_drawer);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //nav = (NavigationView) findViewById(R.id.navView_main);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment t;
                FragmentManager fm = ((AppCompatActivity)getActivity()).getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                TabViewPageAdapter adapter = new TabViewPageAdapter(((AppCompatActivity)getActivity()).getSupportFragmentManager());

                switch (id) {
                    case R.id.thoisu:
                      //  adapter.addFragment_TabView(new ThoiSuFragment(), "Thời Sự");
                        firstViewPager.setCurrentItem(0);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.gocnhin:
                        firstViewPager.setCurrentItem(1);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.thegioi:
                        firstViewPager.setCurrentItem(2);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.thethao:
                        firstViewPager.setCurrentItem(3);
                        drawerLayout.closeDrawers();
                        return true;
                    case  R.id.congnghe:
                        firstViewPager.setCurrentItem(4);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.giaitri:
                        firstViewPager.setCurrentItem(5);
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.khoahoc:
                        firstViewPager.setCurrentItem(6);
                        drawerLayout.closeDrawers();
                        return true;

                }
                firstViewPager.setAdapter(adapter);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }

        });
        return rootView;
    }
    public void Menu(){



    }
    private void setupViewPager(ViewPager viewPager) {
        TabViewPageAdapter adapter = new TabViewPageAdapter(getChildFragmentManager());
        adapter.addFragment_TabView(new ThoiSuFragment(), "Thời Sự");
        adapter.addFragment_TabView(new GocNhinFragment(),"Góc Nhìn");
        adapter.addFragment_TabView(new TheGioiFragment(), "Thế Giới");
        adapter.addFragment_TabView(new TheThaoFragment(),"Thể Thao");
        adapter.addFragment_TabView(new CongNgheFragment(),"Công Nghệ");
        adapter.addFragment_TabView(new GiaiTriFragment(),"Giải Trí");
        adapter.addFragment_TabView(new KhoaHocFragment(),"Khoa Học");
        viewPager.setAdapter(adapter);
    }
}
