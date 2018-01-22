package com.semanientreprise.tachymns.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llollox.androidtoggleswitch.widgets.ToggleSwitch;
import com.semanientreprise.tachymns.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Song_Fragment extends Fragment implements ToggleSwitch.OnChangeListener {
    private View songFragView;
    @Bind(R.id.langToggleSwitch)
    ToggleSwitch SongFragmentlangToggleSwitch;
    private final int position = 0;

    //Empty Constructor
    public Song_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        songFragView = inflater.inflate(R.layout.song_frag, container, false);
        ButterKnife.bind(this, songFragView);

        //Set the default toggle switch position at 0 which is English
        SongFragmentlangToggleSwitch.setCheckedPosition(position);
        SongFragmentlangToggleSwitch.setOnChangeListener(this);

        showFragment(new EnglishHymnFragment());

        return songFragView;
    }

    @Override
    public void onToggleSwitchChanged(int position) {
        switch (position) {
            case 0:
                showFragment(new EnglishHymnFragment());
                break;
            case 1:
                showFragment(new YourbaHymnFragment());
                break;
            case 2:
                showFragment(new HausaHymnFragment());
                break;
            case 3:
                showFragment(new IgboHymnFragment());
                break;
        }
    }

    private void showFragment(Fragment fragment) {
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}