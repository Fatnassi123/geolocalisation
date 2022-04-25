package com.example.geolocalisation.services;

import com.example.geolocalisation.models.Vehicules;
import com.example.geolocalisation.repositories.VehiculesRepository;

import java.util.List;
import java.util.Optional;

public class VehiculesService implements VehiculesServices{

    private VehiculesRepository vehiculesRepository ;


  //  @Override
   // public List<Vehicules> getAllVehicules() {
     //   return vehiculesRepository.findAll();
    //}

   // @Override
   // public Optional<Vehicules> findVehiculesById(Long id) {
    //    return vehiculesRepository.findById(id);
   // }

    @Override
    public Vehicules createVehicules(Vehicules vehicules) {
        return vehiculesRepository.save(vehicules);
    }

    @Override
    public Vehicules updateVehicules(Vehicules vehicules) {
        return vehiculesRepository.save(vehicules);
    }

    @Override
    public void deleteVehicules(Long id) {
        vehiculesRepository.deleteById(id);

    }
}
