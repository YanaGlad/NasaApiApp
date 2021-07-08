package com.example.nasaappglad.model;

import com.google.gson.annotations.SerializedName;

public class Rover {

    @SerializedName("id")
    private Integer id;

//    @SerializedName("name")
//    private String name;
//
//    @SerializedName("landing_date")
//    private String landing_date;
//
//    @SerializedName("launch_date")
//    private String launch_date;
//
//    @SerializedName("status")
//    private String status;

    @SerializedName("img_src")
    private String img_src;

    public RoverModel createRoverModel() {
        return new RoverModel(id, img_src);
    }
}
