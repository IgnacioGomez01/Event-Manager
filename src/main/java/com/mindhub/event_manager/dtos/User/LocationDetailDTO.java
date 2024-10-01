package com.mindhub.event_manager.dtos.User;

import com.mindhub.event_manager.models.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class LocationDetailDTO {
    private UUID id;
    private String name;
    private int capacity;
    private String img;
    private Set<EventSummaryDTO> events = new HashSet<>();

    public LocationDetailDTO(Location location){
        this.id = location.getId();
        this.name = location.getName();
        this.capacity = location.getCapacity();
        this.img = location.getImg();
        this.events = location.getEventLocations().stream().map(el->new EventSummaryDTO(el.getEvent())).collect(Collectors.toSet());
    }
}
