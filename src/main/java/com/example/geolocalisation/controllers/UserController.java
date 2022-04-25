package com.example.geolocalisation.controllers;


import com.example.geolocalisation.configurations.JwtResponse;
import com.example.geolocalisation.configurations.jwt.JwtUtils;
import com.example.geolocalisation.models.LoginRequest;
import com.example.geolocalisation.models.RegistrationRequest;
import com.example.geolocalisation.models.User;
import com.example.geolocalisation.services.RegistrationService;
import com.example.geolocalisation.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    RegistrationService registrationService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = RequestMethod.POST)
    @PostMapping(value = "/auth/signIn")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),roles,userDetails.getFirstName(),userDetails.getLastName(),true));
    }

    @PostMapping(path = "/forgetPassword")
    public String forgetPassword(@RequestParam("email") String email) {
        return userService.forgetPassword(email);
    }
    @GetMapping(path = "/resetPassword/reset")
    public String resetPassword(@RequestParam("token")String token) {
        return userService.resetPassword(token);
    }
    @PostMapping(path = "/resetPassword/reset")
    public String changePassword(@RequestParam("email") String email,@RequestParam("newPassword") String newPassword) {
        return registrationService.changePassword(email,newPassword);
    }
    @GetMapping(path = "/users")
    public List<User> getAllUsers(@RequestHeader("Authorization") String token){
        User user = (User) userService.loadUserByUsername(jwtUtils.getUserNameFromJwtToken(token));
        return userService.getAllUsers(user);
    }
}
