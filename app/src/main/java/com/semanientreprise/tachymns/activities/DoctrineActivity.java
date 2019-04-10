package com.semanientreprise.tachymns.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.fragment.RulesOfBelieveFrag;
import com.semanientreprise.tachymns.fragment.RulesOfConductFrag;
import com.semanientreprise.tachymns.fragment.TenetFrag;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctrineActivity extends AppCompatActivity {
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.tab_layout) TabLayout tabLayout;
    @BindView(R.id.pager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctrine);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("TAC DOCTRINE");
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new RulesOfBelieveFrag(), getString(R.string.rules_of_believe));
        adapter.addFrag(new RulesOfConductFrag(), getString(R.string.rules_of_conduct));
        adapter.addFrag(new TenetFrag(), getString(R.string.tenet));

        viewPager.setAdapter(adapter);
    }
}
