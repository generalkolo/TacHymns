package com.semanientreprise.tachymns.utils;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.semanientreprise.tachymns.activities.HymnDetails;



public class BaseFragment extends Fragment {

    public static final String HYMN_SELECTION = "HYMN_SELECTION";
    public static final String POSITION_SELECTED = "POSITION_SELECTED";

    public void sendHymnDetailsToDetailsActivity(int position,String selection) {

        Intent hymnDetails = new Intent(getActivity(), HymnDetails.class);

        hymnDetails.putExtra(POSITION_SELECTED, position);
        hymnDetails.putExtra(HYMN_SELECTION, selection);

        startActivity(hymnDetails);
    }

}
