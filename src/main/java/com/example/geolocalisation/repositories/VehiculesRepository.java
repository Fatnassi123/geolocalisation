package com.example.geolocalisation.repositories;

import com.example.geolocalisation.models.Vehicules;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculesRepository extends JpaRepository<Vehicules , Long> {
}
