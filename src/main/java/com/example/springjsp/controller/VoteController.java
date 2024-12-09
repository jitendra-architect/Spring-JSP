package com.example.springjsp.controller;

import com.example.springjsp.exception.AgeNotValidException;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vote")
public class VoteController {

   // @Autowired
   // private ObservationRegistry observationRegistry;

    @GetMapping("/age")
    public ResponseEntity<String> checkAge(@RequestParam("age") int age) {
        if (age < 18) {
            throw new AgeNotValidException("Age must be at least 18");
        }
       return new ResponseEntity<>("OK", HttpStatus.OK);
        //return observationRegistry.getCurrentObservation().observe(()-> ResponseEntity.status(HttpStatus.OK).build());
    }
}
