package com.semanientreprise.tachymns.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semanientreprise.tachymns.utils.BaseFragment;
import com.semanientreprise.tachymns.utils.CustomItemClickListener;
import com.semanientreprise.tachymns.data.DataFeeder;
import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.adapter.SongAdapter;
import com.semanientreprise.tachymns.model.SongsGAndS;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnglishHymnFragment extends BaseFragment {
    @BindView(R.id.song_recView)
    RecyclerView hymnRecView;
    Unbinder unbinder;
    private SongAdapter songAdapter;
    List<SongsGAndS> returnedList;
    public static List<SongsGAndS> dataTobeSent;

    public static final String ENGLISH_SELECTION = "ENGLISH_SELECTION";

    public EnglishHymnFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_english, container, false);
        unbinder = ButterKnife.bind(this, view);

        //Getting the returned list of songs and passing it to the adapter
        returnedList = DataFeeder.getEnglishData();
        dataTobeSent = returnedList;

        songAdapter = new SongAdapter(returnedList, getActivity(), 1, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                sendHymnDetailsToDetailsActivity(position,ENGLISH_SELECTION);
            }
        });

        hymnRecView.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL, false));
        hymnRecView.setHasFixedSize(true);

        hymnRecView.setAdapter(songAdapter);

        return view;
    }

    /*public void changeSortingOptionClicked(int determinant) {
        songAdapter = new SongAdapter(returnedList, getActivity(), determinant, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                sendHymnDetailsToDetailsActivity(position);
            }
        });
        hymnRecView.setAdapter(songAdapter);
    }*/

    public static List<SongsGAndS> getDataTobeSent() {
        return dataTobeSent;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
