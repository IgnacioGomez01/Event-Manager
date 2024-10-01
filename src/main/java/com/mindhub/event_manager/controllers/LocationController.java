package com.mindhub.event_manager.controllers;

import com.mindhub.event_manager.dtos.User.LocationDetailDTO;
import com.mindhub.event_manager.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/location")
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public ResponseEntity<List<LocationDetailDTO>> getLocations(){
        return new ResponseEntity<>(locationRepository.findAll().stream().map(LocationDetailDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationDetailDTO> getLocationById(@PathVariable UUID locationId){
        return new ResponseEntity<>(locationRepository.findById(locationId).map(LocationDetailDTO::new).orElseThrow(()->new RuntimeException()),HttpStatus.OK);
    }

}
