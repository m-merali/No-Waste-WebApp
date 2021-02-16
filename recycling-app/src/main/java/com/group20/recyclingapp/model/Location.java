package com.group20.recyclingapp.model;

import javax.persistence.*;

@Entity
@Table
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //AUTO or IDENTITY - figure out which one...
	private Long id;
	private Long latitude;
	private Long longitude;

	@OneToOne
    private RecyclingCentre recyclingCentre;

    public Location() {
    }

    public Location(Long id, Long latitude, Long longitude, RecyclingCentre recyclingCentre) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.recyclingCentre = recyclingCentre;
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

    public RecyclingCentre getRecyclingCentre() {
        return recyclingCentre;
    }

    public void setRecyclingCentre(RecyclingCentre recyclingCentre) {
        this.recyclingCentre = recyclingCentre;
    }
}
