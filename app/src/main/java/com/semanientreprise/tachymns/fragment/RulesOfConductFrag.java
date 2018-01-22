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

/**
 * A simple {@link Fragment} subclass.
 */
public class RulesOfConductFrag extends Fragment implements ToggleSwitch.OnChangeListener {

    @Bind(R.id.langToggleSwitch)
    ToggleSwitch rulesOfConductToggleSwitch;

    public RulesOfConductFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.rules_of_conduct_frag, container, false);
        ButterKnife.bind(this, view);

        rulesOfConductToggleSwitch.setCheckedPosition(0);

        //Set the position of the Selector and set the onChangeListener
        rulesOfConductToggleSwitch.setOnChangeListener(this);

        //Show the English version of the Rules of Belief
        showFragment(new EnglishConductTac());

        return view;
    }

    private void showFragment(Fragment fragment) {
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.roc_content_frame, fragment)
                .commit();
    }

    @Override
    public void onToggleSwitchChanged(int position) {
        switch (position) {
            case 0:
                showFragment(new EnglishConductTac());
                break;
            case 1:
                showFragment(new YorubaConductTac());
                break;
            case 2:
                showFragment(new HausaConductTac());
                break;
            case 3:
                showFragment(new IgboConductTac());
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
