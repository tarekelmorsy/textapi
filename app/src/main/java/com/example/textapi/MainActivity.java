package com.example.textapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView1,textView2,textView3;
    Button button;
    String TAG ="lklm";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1= findViewById(R.id.textView);
        textView2= findViewById(R.id.textView2);
        textView3= findViewById(R.id.textView3);
        button= findViewById(R.id.button);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "https://testing.sary.co/api/location/").addConverterFactory(GsonConverterFactory.create())
                .build();
        Interfice interfice= retrofit.create(Interfice.class);
        Call<Model> modelCall = interfice.getPosts("26.291883500488073","50.172840245068066");
        modelCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
              // textView1.setText(response.body().getId());
                Log.i(TAG, "An : " +response.body().toString());


               textView2.setText(response.body().getMessage_en());
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                textView1.setText("error");


            }
        });

    }




}
