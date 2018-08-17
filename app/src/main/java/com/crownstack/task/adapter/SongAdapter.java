package com.crownstack.task.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.crownstack.task.R;
import com.crownstack.task.databinding.SongItemBinding;
import com.crownstack.task.model.Song;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private Song song;
    private LayoutInflater layoutInflater;
    private ItemClick itemClick;

    public class SongViewHolder extends RecyclerView.ViewHolder {
        SongItemBinding binding;

        public SongViewHolder(SongItemBinding v) {
            super(v.getRoot());
            binding=v;
            binding.setItemClick(itemClick);
        }
    }

    public SongAdapter(ItemClick itemClick, Song songs) {
        song = songs;
        this.itemClick=itemClick;
    }


    @Override
    public SongAdapter.SongViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        SongItemBinding binding =DataBindingUtil.inflate(layoutInflater, R.layout.song_item, parent, false);
        return new SongViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, final int position) {
        holder.binding.setSongItem(song.getResults().get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return song.getResults().size();
    }

    public interface ItemClick{
        void onSongItemClick(Song.SongItem songItem);
        void onPauseClick(Song.SongItem songItem);
        void onPlayClick(Song.SongItem songItem);
    }
}