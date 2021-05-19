package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distillaryRepository;

    @GetMapping(value = "/distillarys")
    public ResponseEntity<List<Distillery>> getAllDistillerys(){
        return new ResponseEntity<>(distillaryRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/distillarys/{id}")
    public ResponseEntity getDistillery(@PathVariable Long id){
        return new ResponseEntity<>(distillaryRepository.findById(id),HttpStatus.OK);
    }
    @PostMapping(value = "/distillarys")
    public ResponseEntity<Distillery> postDistillery(@RequestBody Distillery distillary){
        distillaryRepository.save(distillary);
        return new ResponseEntity<>(distillary,HttpStatus.CREATED);
    }

}
