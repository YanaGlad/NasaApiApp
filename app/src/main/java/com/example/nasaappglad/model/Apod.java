package com.example.nasaappglad.model;

import com.google.gson.annotations.SerializedName;

public class Apod {
    @SerializedName("copyright")
    private String copyright;

    @SerializedName("date")
    private String date;

    @SerializedName("explanation")
    private String explanation;

    @SerializedName("hdurl")
    private String hdurl;

    @SerializedName("media_type")
    private String media_type;

    @SerializedName("service_version")
    private String service_version;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    public ApodModel createApodModel(){
        return  new ApodModel(copyright, date, explanation, hdurl, media_type, service_version, title, url);
    }
}
