package com.example.nasaappglad.api;


import com.example.nasaappglad.model.Apod;
import com.example.nasaappglad.model.Rovers;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("planetary/apod?api_key=uej4DeQlgTn9GRLfb98qSj38c2mecIuWspj3JyTN")
    Call<Apod> getAstronomyImageOfTheDay();

    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&page=2&api_key=uej4DeQlgTn9GRLfb98qSj38c2mecIuWspj3JyTN")
    Call<Rovers> getMarsPhotos();
            //@Query("sol") int sol,
          //  @Query("page") int page);
}
