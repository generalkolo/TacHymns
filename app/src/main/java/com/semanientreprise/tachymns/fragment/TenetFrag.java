package com.semanientreprise.tachymns.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.llollox.androidtoggleswitch.widgets.ToggleSwitch;
import com.semanientreprise.tachymns.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TenetFrag extends Fragment implements ToggleSwitch.OnChangeListener {

    @BindView(R.id.langToggleSwitch)
    ToggleSwitch tentsToggleSwitch;
    private Unbinder unbinder;

    public TenetFrag() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.tenet_frag, container, false);
        unbinder = ButterKnife.bind(this, view);

        tentsToggleSwitch.setCheckedPosition(0);

        //Set the position of the Selector and set the onChangeListener
        tentsToggleSwitch.setOnChangeListener(this);

        //Show the English version of the Rules of Belief
        showFragment(new EnglishTentsTac());

        return view;
    }


    private void showFragment(Fragment fragment) {
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.tenets_content_frame, fragment)
                .commit();
    }

    @Override
    public void onToggleSwitchChanged(int position) {
        switch (position) {
            case 0:
                showFragment(new EnglishTentsTac());
                break;
            case 1:
                showFragment(new YorubaTenetsTac());
                break;
            case 2:
                showFragment(new HausaTenetsTac());
                break;
            case 3:
                showFragment(new IgboTenetsTac());
                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
