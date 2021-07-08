package com.example.nasaappglad.api;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Instance {
    private static final String DOMAIN = "https://api.nasa.gov/";
    private static Retrofit.Builder builder;

    public static Retrofit getInstance() {
        if (builder == null) {
            builder = new Retrofit.Builder();

            OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();

            builder.baseUrl(DOMAIN)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                    .client(okHttpBuilder.build());

        }
        return builder.build();
    }
}
