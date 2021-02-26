package com.group20.recyclingapp.processor;

import com.group20.recyclingapp.model.Location;
import com.group20.recyclingapp.model.RecyclingCentre;

//used for the calculation of the distance between the location

public class LocationDistance {
    private Location location;
    private RecyclingCentre recyclingCentre;
    private double distance;

    public LocationDistance(Location location, RecyclingCentre recyclingCentre, double distance) {
        this.location = location;
        this.recyclingCentre = recyclingCentre;
        this.distance = distance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public RecyclingCentre getRecyclingCentre() {
        return recyclingCentre;
    }

    public void setRecyclingCentre(RecyclingCentre recyclingCentre) {
        this.recyclingCentre = recyclingCentre;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
