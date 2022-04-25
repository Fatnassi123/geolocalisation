package com.example.geolocalisation.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "confirmationtokens")
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "token")
    private String token;
    @Column(name= "createdAt")
    private LocalDateTime createdAt;
    @Column(name = "expiresAt")
    private LocalDateTime expiresAt;
    @Column(name = "confirmedAt")
    private LocalDateTime confirmedAt;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt , User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}
