package com.mindhub.event_manager.dtos.User;

import com.mindhub.event_manager.models.CustomerEventLocation;
import com.mindhub.event_manager.models.Event;
import com.mindhub.event_manager.models.Location;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class EventLocationDTO {

    private UUID id;
    private Event event;
    private Location location;
    private Set<CustomerEventLocation> customerEventLocations = new HashSet<>();
    private LocalDateTime date;
    private int assistance;


}
