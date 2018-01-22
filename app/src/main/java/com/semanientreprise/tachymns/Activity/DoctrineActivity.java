package com.semanientreprise.tachymns.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.fragment.RulesOfBelieveFrag;
import com.semanientreprise.tachymns.fragment.RulesOfConductFrag;
import com.semanientreprise.tachymns.fragment.TenetFrag;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DoctrineActivity extends AppCompatActivity {
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.tab_layout) TabLayout tabLayout;
    @Bind(R.id.pager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctrine);
        ButterKnife.bind(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle("TAC HYMNS");

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
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
