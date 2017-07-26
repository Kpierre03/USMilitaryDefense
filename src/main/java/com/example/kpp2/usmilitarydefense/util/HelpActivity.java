package com.example.kpp2.usmilitarydefense.util;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.kpp2.usmilitarydefense.R;
import com.example.kpp2.usmilitarydefense.adapter.ViewFragmentStateAdapter;
import com.example.kpp2.usmilitarydefense.fragment.AirForceFragment;
import com.example.kpp2.usmilitarydefense.fragment.ArmyFragment;
import com.example.kpp2.usmilitarydefense.fragment.MarinesFragment;
import com.example.kpp2.usmilitarydefense.fragment.NavyFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kpp2 on 7/26/17.
 */

public class HelpActivity extends AppCompatActivity {
    private ArrayList<Pair<String, Fragment>> list = new ArrayList<Pair<String, Fragment>>();



    @BindView(R.id.activity_advance_view_pager_tablayout)
    TabLayout tabLayout;


    @BindView(R.id.activity_advance_view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ButterKnife.bind(this);

        list.add(new Pair<String, Fragment>("Marines", new MarinesFragment()));
        list.add(new Pair<String, Fragment>("Navy", new NavyFragment()));
        list.add(new Pair<String, Fragment>("Air Force", new AirForceFragment()));
        list.add(new Pair<String, Fragment>("Army", new ArmyFragment()));


        ViewFragmentStateAdapter adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
