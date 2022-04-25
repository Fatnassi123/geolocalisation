package com.example.geolocalisation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vehicules")
public class Vehicules implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "marque")
    private String Marque ;
    @Column(name = "matricule")
    private String Matricule ;
    @Column(name = "couleur" )
    private String Couleur ;
}
