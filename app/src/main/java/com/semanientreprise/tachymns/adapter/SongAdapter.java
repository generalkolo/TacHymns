package com.semanientreprise.tachymns.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.semanientreprise.tachymns.utils.CustomItemClickListener;
import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.model.SongsGAndS;

import java.util.List;

/**
 * Created by Ebenezer on 2/13/2017.
 */
public class SongAdapter extends RecyclerView.Adapter<SongAdapter.HymnViewHolder> {

        private List<SongsGAndS> listData;
        private LayoutInflater inflater;
        CustomItemClickListener listener;
        private int sortByMode;

        public SongAdapter(List<SongsGAndS> arrayList, Context c, int sortByMode, CustomItemClickListener listener ) {
            this.listData = arrayList;
            this.inflater = LayoutInflater.from(c);
            this.listener = listener;
            this.sortByMode = sortByMode;
        }

    @Override
        public HymnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.row_hymn_title,parent,false);
            final HymnViewHolder hymnViewHolder = new HymnViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v,hymnViewHolder.getAdapterPosition());
                }
            });

            return hymnViewHolder;
        }

        @Override
        public void onBindViewHolder(HymnViewHolder holder, int position) {
            SongsGAndS songGetterAndSetter = listData.get(position);
            switch (sortByMode){
                case 1:
                    holder.songTitle.setText(songGetterAndSetter.getHymnChorus());
                    break;
                case 2:
                    holder.songTitle.setText(String.valueOf(songGetterAndSetter.getHymnNumber()));
                    break;
                case 3:
                    holder.songTitle.setText(String.valueOf(songGetterAndSetter.getSongName()));
                    break;
            }
            holder.favoriteImage.setImageResource(songGetterAndSetter.getFavourites());
        }

        @Override
        public int getItemCount() {
            return listData.size();
        }

        class HymnViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            //TODO: Use butterknife injection here bud
            private TextView songTitle;
            private ImageView favoriteImage;
            Context c;

            public HymnViewHolder(View itemView) {
                super(itemView);
                songTitle = itemView.findViewById(R.id.song_text);
                favoriteImage = itemView.findViewById(R.id.favoriteImage);
                favoriteImage.setOnClickListener(this);
                c = itemView.getContext();
            }

            @Override
            public void onClick(View v) {
                SongsGAndS songGetterAndSetter = listData.get(getAdapterPosition());
                if(!songGetterAndSetter.isFavourite()){
                    songGetterAndSetter.setFavourites(R.drawable.ic_star_black_24dp);
                    songGetterAndSetter.setFavourite(true);
                    notifyDataSetChanged();
                }
                else{
                    songGetterAndSetter.setFavourites(R.drawable.ic_star_border_black_24dp);
                    songGetterAndSetter.setFavourite(false);
                    notifyDataSetChanged();
                }
            }
        }
    }
