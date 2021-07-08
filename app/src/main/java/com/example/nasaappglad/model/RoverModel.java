package com.example.nasaappglad.model;

public class RoverModel {
    private Integer id;
    private String name;
    private String landing_date;
    private String launch_date;
    private String status;
    private String img_src;

    public RoverModel(Integer id, String img_src) {
        //, Integer id, String name, String landing_date, String launch_date, String status
        this.id = id;
//        this.name = name;
//        this.landing_date = landing_date;
//        this.launch_date = launch_date;
//        this.status = status;
        this.img_src = img_src;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public String getImg_src() {
        return img_src;
    }

    public String getLanding_date() {
        return landing_date;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    public String getStatus() {
        return status;
    }


}
