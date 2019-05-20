package com.example.pruebafinalxd;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.example.pruebafinalxd.R;
import com.example.pruebafinalxd.OneFragment;
import com.example.pruebafinalxd.TwoFragment;
import com.example.pruebafinalxd.ThreeFragment;
import com.example.pruebafinalxd.FourFragment;



public class ElementosFragment extends Fragment {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public ElementosFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_elementos, container, false);
        toolbar=view.findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager)view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout =view.findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }



    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter= new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new OneFragment(), "Bloque S");
        adapter.addFragment(new TwoFragment(), "Bloque P");
        adapter.addFragment(new ThreeFragment(), "Bloque D");
        adapter.addFragment(new FourFragment(), "Bloque F");
        viewPager.setAdapter(adapter);
    }




}
class ViewPagerAdapter extends FragmentPagerAdapter{
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }

}


