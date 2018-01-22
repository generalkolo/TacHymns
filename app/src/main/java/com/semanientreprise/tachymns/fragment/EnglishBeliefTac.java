package com.semanientreprise.tachymns.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.semanientreprise.tachymns.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnglishBeliefTac extends Fragment {


    public EnglishBeliefTac() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.english_belief_tac_fragment, container, false);
        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.tv_rob_actsFourTwelve, R.id.tv_rob_romTenNineteen, R.id.tv_rob_hebThirteenSeventeen,
            R.id.tv_rob_ephFourEleven, R.id.tv_rob_FirstCorinthiansTwelveTwentyEight, R.id.tv_rob_hebTenTwentyFive,
            R.id.tv_rob_secondJohnOneNine, R.id.tv_rob_romansSixFour, R.id.tv_rob_lukeTwentyTwoNineteen,
            R.id.tv_rob_FirstCorinthiansElevenTwelve, R.id.tv_rob_genFourteenTwenty, R.id.tv_rob_genTwentyEightTwentyTwo,
            R.id.tv_rob_leviticusTwentySevenThirty, R.id.tv_rob_FirstChroniclesTwentyNineFourteen, R.id.tv_rob_hebSevenEight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_rob_actsFourTwelve:
                showScripture("Acts Four Twelve");
                break;
            case R.id.tv_rob_romTenNineteen:
                break;
            case R.id.tv_rob_hebThirteenSeventeen:
                break;
            case R.id.tv_rob_ephFourEleven:
                break;
            case R.id.tv_rob_FirstCorinthiansTwelveTwentyEight:
                break;
            case R.id.tv_rob_hebTenTwentyFive:
                break;
            case R.id.tv_rob_secondJohnOneNine:
                break;
            case R.id.tv_rob_romansSixFour:
                break;
            case R.id.tv_rob_lukeTwentyTwoNineteen:
                break;
            case R.id.tv_rob_FirstCorinthiansElevenTwelve:
                break;
            case R.id.tv_rob_genFourteenTwenty:
                break;
            case R.id.tv_rob_genTwentyEightTwentyTwo:
                break;
            case R.id.tv_rob_leviticusTwentySevenThirty:
                break;
            case R.id.tv_rob_FirstChroniclesTwentyNineFourteen:
                break;
            case R.id.tv_rob_hebSevenEight:
                break;
        }
    }

    private void showScripture(String Scripture) {
        Toast.makeText(getActivity(), ""+Scripture, Toast.LENGTH_SHORT).show();
    }
}
