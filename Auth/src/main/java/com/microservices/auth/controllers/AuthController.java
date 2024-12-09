package com.microservices.auth.controllers;

import com.microservices.auth.models.User;
import com.microservices.auth.models.UserId;
import com.microservices.auth.models.JwtResponse;
import com.microservices.auth.models.LoginRequest;
import com.microservices.auth.models.Message;
import com.microservices.auth.repositories.UserRepository;
import com.microservices.auth.services.JwtUtils;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return new ResponseEntity<>(new Message("Email gia' registrata!", 400), HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        User userFound = userRepository.findByEmail(user.getEmail()).get();
        UserId userId = new UserId(userFound.getId());
        return new ResponseEntity<>(userId, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Credenziali errate!"));
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body(new JwtResponse("Credenziali errate!"));
        }
        String token = jwtUtils.generateToken(loginRequest.getEmail());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @GetMapping("/shop-purchase/userId")
    public String secureEndpoint(@RequestHeader("Authorization") String authorizationHeader) {
        // Estrarre il token dal header
        String token = authorizationHeader.replace("Bearer ", "");

        // Puoi ora validare il token
        if (!jwtUtils.validateToken(token)) {
            return "Token non valido!";
        }
        return "Token ricevuto: " + token;
    }

}
