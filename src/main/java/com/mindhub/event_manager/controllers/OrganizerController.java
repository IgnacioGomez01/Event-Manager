package com.mindhub.event_manager.controllers;

import com.mindhub.event_manager.dtos.User.OrganizerDetailDTO;
import com.mindhub.event_manager.repositories.OrganizerRepository;
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
@RequestMapping("/api/organizer")
public class OrganizerController {
    @Autowired
    private OrganizerRepository organizerRepository;

    @GetMapping
    public ResponseEntity<List<OrganizerDetailDTO>> getOrganizers(){
        return new ResponseEntity<>(organizerRepository.findAll().stream().map(OrganizerDetailDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{organizerId}")
    public ResponseEntity<OrganizerDetailDTO> getOrganizerById(@PathVariable UUID organizerId){
        return new ResponseEntity<>(organizerRepository.findById(organizerId).map(OrganizerDetailDTO::new).orElseThrow(()->new RuntimeException()),HttpStatus.OK);
    }
}
