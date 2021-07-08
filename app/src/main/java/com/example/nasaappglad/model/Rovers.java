package com.example.nasaappglad.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Rovers {
    @SerializedName("photos")
    @Expose
    private ArrayList<Rover> rovers = null;

    public ArrayList<Rover> getRovers() {
        return rovers;
    }
}


