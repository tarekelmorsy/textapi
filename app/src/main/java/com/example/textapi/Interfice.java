package com.example.textapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interfice {
    @GET("locate")
    public Call<Model> getPosts(@Query("lat")String lat, @Query("lng")String lng);



}
