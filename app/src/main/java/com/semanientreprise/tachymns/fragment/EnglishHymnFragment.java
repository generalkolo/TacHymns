package com.semanientreprise.tachymns.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.semanientreprise.tachymns.Activity.HymnDetails;
import com.semanientreprise.tachymns.Custom.CustomItemClickListener;
import com.semanientreprise.tachymns.Data.DataFeeder;
import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.adapter.SongAdapter;
import com.semanientreprise.tachymns.model.SongsGAndS;

import java.io.Serializable;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnglishHymnFragment extends Fragment {
    private SongAdapter songAdapter;
    private RecyclerView.LayoutManager songFragmentLinearLayoutManager;
    List<SongsGAndS> returnedList;
    private Animation FabOpen, FabClose, FabRClockwise, FabRAntiClockwise;
    private boolean isOpen = false;
    private int determinant;
    public static List<SongsGAndS> dataTobeSent;
    @Bind(R.id.song_recView) RecyclerView hymnRecView;
    /*@Bind(R.id.fab) FloatingActionButton fab;
    @Bind(R.id.fab_hymn_chorus_sort) FloatingActionButton fabHymnChorusSort;
    @Bind(R.id.fab_hymn_firstLine_sort) FloatingActionButton fabHymnFirstLineSort;
    @Bind(R.id.fab_hymn_number_sort) FloatingActionButton fabHymnNumberSort;*/

    public EnglishHymnFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_english, container, false);
        ButterKnife.bind(this, view);

        //LinearLayoutManager for the songs of the hymn
        songFragmentLinearLayoutManager = new LinearLayoutManager(this.getActivity(),
                LinearLayoutManager.VERTICAL, false);

//        initializeToggleSwitch();
//        initializeAnimations();

        //Getting the returned list of songs and passing it to the adapter
        returnedList = DataFeeder.getListData();
        dataTobeSent = returnedList;

        songAdapter = new SongAdapter(returnedList, getActivity(), 1, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                sendHymnDetailsToDetailsActivity(position);
            }
        });

        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {

                    isOpen = true;
                    fabHymnChorusSort.setClickable(true);
                    fabHymnNumberSort.setClickable(true);
                    fabHymnFirstLineSort.setClickable(true);
                    fabHymnChorusSort.startAnimation(FabOpen);
                    fabHymnNumberSort.startAnimation(FabOpen);
                    fabHymnFirstLineSort.startAnimation(FabOpen);
                    fab.startAnimation(FabRClockwise);
                } else {

                    isOpen = false;
                    fabHymnChorusSort.setClickable(false);
                    fabHymnNumberSort.setClickable(false);
                    fabHymnFirstLineSort.setClickable(false);
                    fabHymnChorusSort.startAnimation(FabClose);
                    fabHymnNumberSort.startAnimation(FabClose);
                    fabHymnFirstLineSort.startAnimation(FabClose);
                    fab.startAnimation(FabRAntiClockwise);
                }
            }
        });

        fabHymnChorusSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                determinant = 1;
                changeSortingOptionClicked(determinant);
            }
        });
        fabHymnNumberSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                determinant = 2;
                changeSortingOptionClicked(determinant);
            }
        });
        fabHymnFirstLineSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                determinant = 3;
                changeSortingOptionClicked(determinant);
            }
        });*/

        hymnRecView.setLayoutManager(songFragmentLinearLayoutManager);
        hymnRecView.setHasFixedSize(true);

        hymnRecView.setAdapter(songAdapter);

        return view;
    }

    public void changeSortingOptionClicked(int determinant) {
        songAdapter = new SongAdapter(returnedList, getActivity(), determinant, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                sendHymnDetailsToDetailsActivity(position);
            }
        });
        hymnRecView.setAdapter(songAdapter);
    }

    private void initializeAnimations() {
        FabOpen = AnimationUtils.loadAnimation(this.getActivity(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(this.getActivity(), R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(this.getActivity(), R.anim.rotate_clockwise);
        FabRAntiClockwise = AnimationUtils.loadAnimation(this.getActivity(), R.anim.rotate_anticlockwise);
    }

    private void sendHymnDetailsToDetailsActivity(int position) {

        Intent hymnDetails = new Intent(getActivity(), HymnDetails.class);

        hymnDetails.putExtra("POSITION",position);
        hymnDetails.putExtra("HYMNCLIKCKER","ENG");

        startActivity(hymnDetails);
    }

    public static List<SongsGAndS> getDataTobeSent() {
        return dataTobeSent;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
