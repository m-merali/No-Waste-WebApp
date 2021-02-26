package com.group20.recyclingapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //AUTO or IDENTITY - figure out which one...
	private Long id;
    @NotNull
	private Long latitude;
    @NotNull
	private Long longitude;
    @NotEmpty
    private String address;


    public Location(Long id, Long latitude, Long longitude, RecyclingCentre recyclingCentre, String address) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
