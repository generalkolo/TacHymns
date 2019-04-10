package com.semanientreprise.tachymns.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.llollox.androidtoggleswitch.widgets.ToggleSwitch;
import com.semanientreprise.tachymns.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Song_Fragment extends Fragment implements ToggleSwitch.OnChangeListener {
    @BindView(R.id.langToggleSwitch)
    ToggleSwitch SongFragmentlangToggleSwitch;
    private View songFragView;
    private int position = -1;
    private Unbinder unbinder;

    private static final String ENGLISH_HYMN_FRAG = "ENGLISH_HYMN_FRAG";
    private static final String YORUBA_HYMN_FRAG = "YORUBA_HYMN_FRAG";
    private static final String HAUSA_HYMN_FRAG = "HAUSA_HYMN_FRAG";
    private static final String IGBO_HYMN_FRAG = "IGBO_HYMN_FRAG";

    private static final String ARG_POSITION = "position";

    private FragmentManager fragmentManager;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Song_Fragment.
     */
    public static Song_Fragment newInstance(int position) {
        Song_Fragment f = new Song_Fragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);

        return f;
    }

    //Empty Constructor
    public Song_Fragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            position = getArguments().getInt(ARG_POSITION);
        Toast.makeText(getActivity(), ""+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        songFragView = inflater.inflate(R.layout.song_frag, container, false);
        unbinder = ButterKnife.bind(this, songFragView);

        fragmentManager = getActivity().getSupportFragmentManager();

        // TODO: Implement sharePreferences so that you can determine the last hymn selection made by the user
        //TODO: And hence you can also set the position of the ToggleSwitch (position variable)
        showFragment(new EnglishHymnFragment());

        position = 0;
        //Set the default toggle switch position at 0 which is English
        SongFragmentlangToggleSwitch.setCheckedPosition(position);
        SongFragmentlangToggleSwitch.setOnChangeListener(this);

        return songFragView;
    }

    @Override
    public void onToggleSwitchChanged(int position) {
        switch (position) {
            case 0:
                EnglishHymnFragment englishHymnFragment = (EnglishHymnFragment) fragmentManager.findFragmentByTag(ENGLISH_HYMN_FRAG);
                if (englishHymnFragment == null)
                    englishHymnFragment = new EnglishHymnFragment();
                    showFragment(englishHymnFragment);
                break;
            case 1:
                YourbaHymnFragment yourbaHymnFragment = (YourbaHymnFragment) fragmentManager.findFragmentByTag(YORUBA_HYMN_FRAG);
                if (yourbaHymnFragment == null)
                    yourbaHymnFragment = new YourbaHymnFragment();
                showFragment(yourbaHymnFragment);
                break;
            case 2:
                HausaHymnFragment hausaHymnFragment = (HausaHymnFragment) fragmentManager.findFragmentByTag(HAUSA_HYMN_FRAG);
                if (hausaHymnFragment == null)
                    hausaHymnFragment = new HausaHymnFragment();
                showFragment(hausaHymnFragment);
                break;
            case 3:
                IgboHymnFragment igboHymnFragment = (IgboHymnFragment) fragmentManager.findFragmentByTag(IGBO_HYMN_FRAG);
                if (igboHymnFragment == null)
                    igboHymnFragment = new IgboHymnFragment();
                showFragment(igboHymnFragment);
                break;
        }
    }

    private void showFragment(Fragment fragment) {
        // Insert the fragment by replacing any existing fragment
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}