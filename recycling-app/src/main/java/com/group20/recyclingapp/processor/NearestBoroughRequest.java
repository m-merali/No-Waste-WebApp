package com.group20.recyclingapp.processor;

import com.group20.recyclingapp.model.RecyclingCentre;

import java.util.List;

public class NearestBoroughRequest {
    private List<RecyclingCentre> centres;
    private double latitude;
    private double longitude;

    public NearestBoroughRequest(List<RecyclingCentre> centres, Long latitude, Long longitude) {
        this.centres = centres;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public List<RecyclingCentre> getCentres() {
        return centres;
    }

    public void setCentres(List<RecyclingCentre> centers) {
        this.centres = centres;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
