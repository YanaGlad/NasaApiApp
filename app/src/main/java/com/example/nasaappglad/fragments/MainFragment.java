package com.example.nasaappglad.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.nasaappglad.R;
import com.example.nasaappglad.api.Api;
import com.example.nasaappglad.api.Instance;
import com.example.nasaappglad.model.Apod;
import com.google.android.material.button.MaterialButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment {

    private void loadGifWithGlide(String url) {

        Glide.with(this)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                // .placeholder(R.drawable.waiting_background)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }
                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imageView);
    }


    MaterialButton toMarsBtn;
    TextView explanation;
    ImageView imageView;
    String url = "https://api.nasa.gov/planetary/apod?api_key=3OROfSQR8chlp7L1fqhm9aDF3JUgFXzLwaLFThij";

    public MainFragment() {
    }

    private Callback<Apod> apodCallback = new Callback<Apod>() {
        @Override
        public void onResponse(Call<Apod> call, Response<Apod> response) {
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    Log.d("ResponseAPOD", response.body().createApodModel().getCopyright() + "\n" +
                            response.body().createApodModel().getExplanation());

                    loadGifWithGlide(response.body().createApodModel().getUrl());
                    explanation.setText( response.body().createApodModel().getExplanation());
                }
            }
        }

        @Override
        public void onFailure(Call<Apod> call, Throwable t) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("OnCreateMainFragme", "doing");
        Api api = Instance.getInstance().create(Api.class);
        api.getAstronomyImageOfTheDay().enqueue(apodCallback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        imageView = view.findViewById(R.id.apod_imgView_main);
        explanation = view.findViewById(R.id.subtitle2);
        toMarsBtn = view.findViewById(R.id.SecAct);
        return view;
    }


}