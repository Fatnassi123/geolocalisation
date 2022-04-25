package com.example.geolocalisation.services;

import com.example.geolocalisation.models.Vehicules;

import java.util.List;
import java.util.Optional;

public interface VehiculesServices {

   // public List<Vehicules> getAllVehicules();
   // public Optional<Vehicules> findVehiculesById(Long id);
    public Vehicules createVehicules (Vehicules vehicules);
    public Vehicules updateVehicules (Vehicules vehicules);
    public void deleteVehicules(Long id);
}
