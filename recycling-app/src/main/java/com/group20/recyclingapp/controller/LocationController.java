package com.group20.recyclingapp.controller;

import com.group20.recyclingapp.model.Location;
import com.group20.recyclingapp.model.RecyclingCentre;
import com.group20.recyclingapp.processor.LocationDistance;
import com.group20.recyclingapp.processor.NearestBoroughRequest;
import com.group20.recyclingapp.repository.LocationRepository;
import com.group20.recyclingapp.repository.RecyclingCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LocationController {

    @Autowired
    LocationRepository locationRepository;
    @Autowired
    RecyclingCentreRepository recyclingCentreRepository;

    @PostMapping("/api/centres")
    public List<RecyclingCentre> showRecyclingCentres()
    {
        return recyclingCentreRepository.findAll();
    }

    @PostMapping("/api/centres/delete")
    public List<RecyclingCentre> deleteRecyclingCentre(@RequestParam("id") Long id)
    {
        Optional<RecyclingCentre> recyclingCentre = recyclingCentreRepository.findById(id);
        recyclingCentre.ifPresent(centre -> recyclingCentreRepository.delete(centre));
        return showRecyclingCentres();
    }

    @PostMapping("/api/centres/new")
    public String addRecyclingCentre(@Valid @RequestBody RecyclingCentre centre, BindingResult bindingResult){
        if ( centre.getLocation().getAddress().isEmpty() || centre.getLocation().getAddress() == null){
            bindingResult.addError(new FieldError("centre", "location", "Location's latitude, longitude and address are required"));
        }
        if (bindingResult.hasErrors()){
            return "error";
        }

        Location savedLocation = locationRepository.save(centre.getLocation());
        centre.setLocation(savedLocation);

        RecyclingCentre savedRecyclingCentre1 = recyclingCentreRepository.save(centre);
        return "saved";
    }

    @PostMapping("/api/centres/nearBy")
    public LocationDistance getNearestRecyclingCentre(@RequestBody NearestBoroughRequest nearestBoroughRequest){
        List<LocationDistance> locationDistances = new ArrayList<>();
        nearestBoroughRequest.getCentres().forEach(centre -> {
            double distance = calcDistanceFromCoordinatesInKm(centre.getLocation().getLatitude(), centre.getLocation().getLongitude(), nearestBoroughRequest.getLatitude(), nearestBoroughRequest.getLongitude());
            LocationDistance locationDistance = new LocationDistance(centre.getLocation(), centre, distance);
            locationDistances.add(locationDistance);
        });
        return locationDistances.get(0);
    }


    //Still working on the PostMapping
    @PostMapping("/api/search")
    public List<LocationDistance> searchLocation(@RequestParam("latitude") Double latitude,@RequestParam("longitude") Double longitude) {
        List<Location> locations = locationRepository.findAll();
        List<LocationDistance> locationDistances = new ArrayList<>();

        locations.forEach(location -> {
           double distance = calcDistanceFromCoordinatesInKm(location.getLatitude(), location.getLongitude(), latitude, longitude);
           RecyclingCentre recyclingCentre = recyclingCentreRepository.findAllByLocation(location);
           LocationDistance locationDistance = new LocationDistance(location, recyclingCentre, distance);
           locationDistances.add(locationDistance);
        });

        locationDistances.sort(new SortByDistance());

        List<LocationDistance> nearestLocations = new ArrayList<>();
        int amount = 0;
        for (LocationDistance locationDistance : locationDistances) {
            nearestLocations.add(locationDistance);
            amount ++;
            //can change number from 3 to any number if you want
            if (amount >=3) {
                break;
            }
        }
        return nearestLocations;
    }


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
    //Used for sorting in ascending order of roll number
    class SortByDistance implements Comparator<LocationDistance> {
        public int compare(LocationDistance a, LocationDistance b) {
            return (int) (a.getDistance() - b.getDistance());
        }
   }

}
