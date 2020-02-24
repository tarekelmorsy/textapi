package com.example.textapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class clint {
    private static Retrofit retrofit;
    private static final String BASE_URL =
            "http://jsonplaceholder.typicode.com/";
    public static Retrofit getretrofit(){

        if (retrofit==null) {

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }



        return retrofit;

    }
}
