package com.example.geolocalisation.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String birthdate;
    private String password;
    private ERole role;

    public RegistrationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
