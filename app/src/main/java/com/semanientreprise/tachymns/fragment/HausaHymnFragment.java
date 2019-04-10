package com.semanientreprise.tachymns.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.utils.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HausaHymnFragment extends BaseFragment {


    public HausaHymnFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hausa, container, false);
    }

}
