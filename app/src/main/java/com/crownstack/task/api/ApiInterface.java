package com.crownstack.task.api;

import com.crownstack.task.model.Song;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("search")
    Call<Song> getSongsList(@Query("term") String term);
}
