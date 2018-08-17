package com.crownstack.task;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.crownstack.task.adapter.SongAdapter;
import com.crownstack.task.api.ApiClient;
import com.crownstack.task.api.ApiInterface;
import com.crownstack.task.databinding.MainBinding;
import com.crownstack.task.model.Song;
import com.crownstack.task.utility.ViewModel;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SongAdapter.ItemClick {

    private MainBinding mainBinding;
    private ViewModel viewModel;
    private SongAdapter.ItemClick itemClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.executePendingBindings();

        viewModel =new ViewModel();
        viewModel.setDialogVisibility(true);
        mainBinding.setVm(viewModel);
        itemClick=this;
        mainBinding.setItemClick(itemClick);
        if(isNetworkAvailable(this)){
            makeApiCall();
            initializeMediaPlayer();
        }else{
            Toast.makeText(this,"network not available",Toast.LENGTH_SHORT).show();
        }

    }
    private void initializeMediaPlayer(){
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                togglePlayPause();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mainBinding.playerControl.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
            }
        });
    }
    private void togglePlayPause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            mainBinding.playerControl.setImageResource(R.drawable.ic_play_circle_filled_black_24dp);
        } else {
            mediaPlayer.start();
            mainBinding.playerControl.setImageResource(R.drawable.ic_pause_circle_filled_black_24dp);
        }
    }
    private void makeApiCall(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Song> call = apiService.getSongsList("Michael jackson");
        call.enqueue(new Callback<Song>() {
            @Override
            public void onResponse(Call<Song> call, Response<Song> response) {
                viewModel.setDialogVisibility(false);

                int statusCode = response.code();
                Song song = response.body();
                mainBinding.rvSongsList.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                mainBinding.rvSongsList.setAdapter(new SongAdapter(MainActivity.this,song));
            }

            @Override
            public void onFailure(Call<Song> call, Throwable t) {
                viewModel.setDialogVisibility(false);
                Log.e("Song", t.toString());
            }
        });
    }

    @Override
    public void onSongItemClick(Song.SongItem songItem) {

        Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
        intent.putExtra("url",songItem.getCollectionViewUrl());
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }


    @Override
    public void onPauseClick(Song.SongItem songItem){
        if(mediaPlayer!=null) {
            if (mediaPlayer.isPlaying()) {
                songItem.setPlaying(false);
                mainBinding.setSongItem(songItem);
                mediaPlayer.pause();
            }

            else if ((!mediaPlayer.isPlaying())) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition());
                mediaPlayer.start();
                songItem.setPlaying(true);
                mainBinding.setSongItem(songItem);
            }
        }
    }

    private MediaPlayer mediaPlayer;
    private Song.SongItem songItem;
    @Override
    public void onPlayClick(Song.SongItem songItem) {
        if (this.songItem != null) {
            this.songItem.setPlaying(false);
            mainBinding.rvSongsList.getAdapter().notifyDataSetChanged();

        }
        this.songItem = songItem;
        this.songItem.setPlaying(true);
        mainBinding.rvSongsList.getAdapter().notifyDataSetChanged();


        mainBinding.setSongItem(songItem);
        mainBinding.selectedTrackTitle.setText(songItem.getTrackName());

        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();
            }
            mediaPlayer = null;
            initializeMediaPlayer();
        }

        try {
            mediaPlayer.setDataSource(songItem.getPreviewUrl());
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();
            }
            mediaPlayer = null;
        }
    }

    public boolean isNetworkAvailable(Context context) {
        boolean status = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = null;
            if (cm != null) {
                netInfo = cm.getNetworkInfo(0);
            }

            if (netInfo != null
                    && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                status = true;
            } else {
                if (cm != null) {
                    netInfo = cm.getNetworkInfo(1);
                }
                if (netInfo != null
                        && netInfo.getState() == NetworkInfo.State.CONNECTED)
                    status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return status;
    }

    boolean isbackPressed;
    @Override
    public void onBackPressed() {

        if(isbackPressed){
            super.onBackPressed();
        }else{
            Toast.makeText(this,"press again to exit",Toast.LENGTH_SHORT).show();
        }
        isbackPressed = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isbackPressed = false;
            }
        },2000);
    }
}