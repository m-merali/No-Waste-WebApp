package com.group20.recyclingapp.controller;

import com.group20.recyclingapp.model.RecyclingCentre;
import com.group20.recyclingapp.processor.LocationDistance;
import com.group20.recyclingapp.repository.LocationRepository;
import com.group20.recyclingapp.repository.RecyclingCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    RecyclingCentreRepository recyclingCentreRepository;


    //Still working on the PostMapping


    // basically the below methods are used to calculate the distance between users location and
    // recycling centres location.
    //calculates great-circle distances between the two points – that is,
    // the shortest distance over the earth’s surface – using the ‘Haversine’ formula.

   public Double calcDistanceFromCoordinatesInKm(double lat1, double long1, Double lat2, Double long2) {
       int radius = 6371; // radius of earth km
       double dLat = deg2rad(lat2 - lat1);
       double dlong = deg2rad(long2 - long1);

       double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
               Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.sin(dlong / 2) * Math.sin(dlong / 2);

       double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 -a));

       return radius * c;

   }

   public Double deg2rad(Double deg) {
       return deg * (Math.PI / 180);
   }

   // something to sort by distance

}
