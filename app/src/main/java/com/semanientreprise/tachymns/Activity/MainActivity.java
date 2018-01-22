package com.semanientreprise.tachymns.Activity;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.fragment.EnglishHymnFragment;
import com.semanientreprise.tachymns.fragment.Favourite_Fragment;
import com.semanientreprise.tachymns.fragment.Song_Fragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.tab_layout) TabLayout tabLayout;
    @Bind(R.id.pager) ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.music_note_tab,
            R.drawable.ic_white_star
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle("TAC HYMNS");
        getSupportActionBar().setLogo(R.drawable.ic_music_note);

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        //Method to set the logos for the fragments
        //setupTabIcons();

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Song_Fragment(), getString(R.string.tab_label1));
        adapter.addFrag(new Favourite_Fragment(), getString(R.string.tab_label2));

        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Main Menu Item Line of code
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, Settings.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.action_sort:
                showSortingOptions();
                break;
            case R.id.action_tacDoctrine:
                startActivity(new Intent(this, DoctrineActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showSortingOptions() {
        final EnglishHymnFragment englishHymnFragment = new EnglishHymnFragment();
        final Dialog dialog = new Dialog(this, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.sorting_dialog);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setBackgroundDrawableResource(R.color.white);
        dialog.setCancelable(true);
        TextView hymnNumberSortText = (TextView) dialog.getWindow().findViewById(R.id.sortHymnNumber);
        TextView hymnChorusSortText = (TextView) dialog.getWindow().findViewById(R.id.sortHymnChorus);
        TextView hymnFirstLineSortText = (TextView) dialog.getWindow().findViewById(R.id.sortFirstLine);

        hymnNumberSortText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                englishHymnFragment.changeSortingOptionClicked(1);
            }
        });

        hymnChorusSortText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                englishHymnFragment.changeSortingOptionClicked(2);
            }
        });

        hymnFirstLineSortText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                englishHymnFragment.changeSortingOptionClicked(3);
            }
        });

        dialog.show();
    }
}
