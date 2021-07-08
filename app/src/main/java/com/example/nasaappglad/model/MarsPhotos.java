package com.example.nasaappglad.model;

import com.google.gson.annotations.SerializedName;

public class MarsPhotos {
    @SerializedName("id")
    private Integer id;

    @SerializedName("sol")
    private Integer sol;

    @SerializedName("img_src")
    private String img_src;

    @SerializedName("earth_date")
    private String earth_date;



}
