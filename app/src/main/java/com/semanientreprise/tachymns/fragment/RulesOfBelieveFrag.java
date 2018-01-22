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
public class RulesOfBelieveFrag extends Fragment implements ToggleSwitch.OnChangeListener {

    @Bind(R.id.langToggleSwitch) ToggleSwitch rulesOfBelieveToggleSwitch;

    public RulesOfBelieveFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.rules_of_believe_fragment, container, false);
        ButterKnife.bind(this, view);

        //Set the position of the Selector and set the onChangeListener
        rulesOfBelieveToggleSwitch.setCheckedPosition(0);
        rulesOfBelieveToggleSwitch.setOnChangeListener(this);

        //Show the English version of the Rules of Belief
        showFragment(new EnglishBeliefTac());

        return view;
    }

    private void showFragment(Fragment fragment) {
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.rob_content_frame, fragment)
                .commit();
    }

    @Override
    public void onToggleSwitchChanged(int position) {
        switch (position) {
            case 0:
                showFragment(new EnglishBeliefTac());
                break;
            case 1:
                showFragment(new YorubaBeliefTac());
                break;
            case 2:
                showFragment(new HausaBeliefTac());
                break;
            case 3:
                showFragment(new IgboBeliefTac());
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
