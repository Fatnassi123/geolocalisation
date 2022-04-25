package com.example.geolocalisation.controllers;

import com.example.geolocalisation.models.Vehicules;
import com.example.geolocalisation.services.VehiculesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
public class VehiculesController {


    private  VehiculesServices vehiculesServices;


    @PostMapping
    public Vehicules createVehicules(@RequestBody Vehicules vehicules){
        return vehiculesServices.createVehicules(vehicules);
    }
    @GetMapping
    public Vehicules updateVehicules(@RequestBody Vehicules vehicules){
        return vehiculesServices.updateVehicules(vehicules);
    }
    @DeleteMapping(path ="/{id}")
    public void deleteVehicules(@PathVariable Long id ){
        vehiculesServices.deleteVehicules(id);
    }
}
