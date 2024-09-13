package com.csc340.assignment2;

public class Weather {
    public String name;
    public String country;
    public String lat;
    public String lon;

    public Weather(String name, String country, String lat, String lon){
        this.name = name;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }
    public String getCountry() {
        return country;
    }
    public String getLat() {
        return lat;
    }
    public String getLon() {
        return lon;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setLat(String lat) {
        this.lat = lat;
    }
    public void setLon(String lon) {
        this.lon = lon;
    }

}


