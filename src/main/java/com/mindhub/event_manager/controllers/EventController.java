package com.mindhub.event_manager.controllers;

import com.mindhub.event_manager.dtos.User.EventCreateDTO;
import com.mindhub.event_manager.dtos.User.EventDetailDTO;
import com.mindhub.event_manager.models.Event;
import com.mindhub.event_manager.models.Organizer;
import com.mindhub.event_manager.repositories.EventRepository;
import com.mindhub.event_manager.repositories.OrganizerRepository;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/event")
public class EventController {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private OrganizerRepository organizerRepository;

    @GetMapping
    public ResponseEntity<List<EventDetailDTO>> getEvents(){
        return new ResponseEntity<>(eventRepository.findAll().stream().map(EventDetailDTO::new).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDetailDTO> getEventById(@PathVariable UUID eventId){
        return new ResponseEntity<>(eventRepository.findById(eventId).map(EventDetailDTO::new).orElseThrow(()->new RuntimeException()),HttpStatus.OK);
    }


    @PostMapping("/{organizerId}")
    public ResponseEntity<?> createEvent(@RequestBody EventCreateDTO eventCreateDTO, @PathVariable UUID organizerId){
        Organizer organizer = organizerRepository.findById(organizerId).get();
        if(organizer.equals(null)){
            return new ResponseEntity<>("Organizer not found", HttpStatus.BAD_REQUEST);
        }
        Event event = new Event(eventCreateDTO,organizer);
        eventRepository.save(event);
        return new ResponseEntity<>(new EventDetailDTO(event),HttpStatus.CREATED);
    }



}