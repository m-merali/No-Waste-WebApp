package com.group20.recyclingapp.controller;

import com.group20.recyclingapp.model.Location;
import com.group20.recyclingapp.model.RecyclingCentre;
import com.group20.recyclingapp.repository.LocationRepository;
import com.group20.recyclingapp.repository.RecyclingCentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    RecyclingCentreRepository recyclingCentreRepository;

    @Autowired
    LocationRepository locationRepository;

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/locations")
    public String showLocations() {
        return "locations";
    }

    @GetMapping("/dates")
    public String showDates(){
        return "dates";
    }

    @GetMapping("/recyclable")
    public String showRecyclable(){
        return "recyclable";
    }

    @GetMapping("/faq")
    public String showfaq(){
        return "faq";
    }

    @GetMapping("/centres")
    public String showRecyclingCentres(Model model) {
        model.addAttribute("recyclingCentres", recyclingCentreRepository.findAll());
        return "recycling-centres";
    }

    @GetMapping("/centres/new")
    public String showAddRecyclingCentre(Model model) {
        RecyclingCentre recyclingCentre = new RecyclingCentre();
        Location location = new Location();
        recyclingCentre.setLocation(location);
        model.addAttribute("centre", recyclingCentre);
        return "add-recycling-centre";
    }

    @GetMapping("/centres/edit/{id}")
    public String showEditRecyclingCentre(@PathVariable("id") long id, Model model) {
        Optional<RecyclingCentre> recyclingCentre = recyclingCentreRepository.findById(id);
        if (recyclingCentre.isEmpty()){
            return "recycling-centres";
        }
        model.addAttribute("centre", recyclingCentre.get());
        return "edit-recycling-centre";
    }

    @PostMapping("/centres/new")
    public String addRecyclingCentre(@Valid @ModelAttribute("centre") RecyclingCentre centre, BindingResult bindingResult) {
        if (centre.getLocation().getAddress().isEmpty() || centre.getLocation().getAddress() == null) {
            bindingResult.addError(new FieldError("centre" , "location", "Location's latitude, longitude and address are required!"));
        }
        if (bindingResult.hasErrors()) {
            return "add-recycling-centre";
        }
        Location savedLocation = locationRepository.save(centre.getLocation());
        centre.setLocation(savedLocation);

        RecyclingCentre savedRecyclingCentre1 = recyclingCentreRepository.save(centre);
        return "redirect:/centres";
    }

    @PostMapping("/centres/update")
    public String updateRecyclingCentre(@Valid @ModelAttribute("centre") RecyclingCentre centre, BindingResult bindingResult) {
        if (centre.getLocation().getAddress().isEmpty() || centre.getLocation().getAddress() == null) {
            bindingResult.addError(new FieldError("centre" , "location", "Location's latitude, longitude and address are required!"));
        }
        if (bindingResult.hasErrors()) {
            return "edit-recycling-centre";
        }
        Location savedLocation = locationRepository.save(centre.getLocation());
        centre.setLocation(savedLocation);

        RecyclingCentre savedRecyclingCentre1 = recyclingCentreRepository.save(centre);
        return "redirect:/centres";
    }

    @GetMapping("/centres/delete/{id}")
    public String deleteRecyclingCentre(@PathVariable("id") Long id){
        Optional<RecyclingCentre> recyclingCentre = recyclingCentreRepository.findById(id);
        recyclingCentre.ifPresent(centre -> recyclingCentreRepository.delete(centre));
        return "redirect:/centres";
    }

}
