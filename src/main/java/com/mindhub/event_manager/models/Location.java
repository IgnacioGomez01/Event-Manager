package com.mindhub.event_manager.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID location_id;

    private String name;
    private int capacity;
    private String img;

    @OneToMany(mappedBy = "location")
    private Set<EventLocation> eventLocations = new HashSet<>();

    public void addEventLocation(EventLocation eventLocation){
        eventLocation.setLocation(this);
        this.eventLocations.add(eventLocation);
    }
}
