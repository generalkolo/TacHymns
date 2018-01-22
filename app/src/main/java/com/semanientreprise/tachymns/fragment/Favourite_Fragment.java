package com.semanientreprise.tachymns.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.semanientreprise.tachymns.Activity.HymnDetails;
import com.semanientreprise.tachymns.Custom.CustomItemClickListener;
import com.semanientreprise.tachymns.Data.DataFeeder;
import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.adapter.SongAdapter;
import com.semanientreprise.tachymns.model.SongsGAndS;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Favourite_Fragment extends Fragment {


    @Bind(R.id.favouriteHymnsRecView) RecyclerView favouriteHymnsRecView;
    @Bind(R.id.favoritesLoader) Button favoritesLoader;
    private RecyclerView.LayoutManager favFragmentLinearLayoutManager;
    List<SongsGAndS> returnedList;
    private SongAdapter songAdapter;

    public Favourite_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.favourite_frag, container, false);
        ButterKnife.bind(this, view);

        favFragmentLinearLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);

        return view;
    }

    private void sendHymnDetailsToDetailsActivity(SongsGAndS songsGAndS) {

        Intent hymnDetails = new Intent(getActivity(), HymnDetails.class);

        hymnDetails.putExtra("SONGTITLE", songsGAndS.getHymnTitle());
        hymnDetails.putExtra("SONGSCRIPTURE", songsGAndS.getHymnScripture());
        hymnDetails.putExtra("HYMNSTANZERSANDCHORUS", songsGAndS.SongStanzasAndChorus());

        startActivity(hymnDetails);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.favoritesLoader)
    public void onViewClicked() {
        //Getting the returned list of songs and passing it to the adapter
        returnedList = DataFeeder.getFavourites();

        songAdapter = new SongAdapter(returnedList, getActivity(), 1, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                sendHymnDetailsToDetailsActivity(returnedList.get(position));
            }
        });

        favouriteHymnsRecView.setLayoutManager(favFragmentLinearLayoutManager);
        favouriteHymnsRecView.setHasFixedSize(true);

        favouriteHymnsRecView.setAdapter(songAdapter);
    }
}
