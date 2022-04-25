package com.example.geolocalisation.configurations;

import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String email;
    private List<String> roles;
    private String firstName;
    private String lastName;
    private Boolean active;

    public JwtResponse(String token, Long id, String email, List<String> roles, String firstName, String lastName, Boolean active) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }

}
