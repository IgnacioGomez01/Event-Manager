package com.mindhub.event_manager.dtos.User;

import com.mindhub.event_manager.models.Location;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class LocationSummaryDTO {

    private UUID id;
    private String name;
    private int capacity;
    private String img;

    public LocationSummaryDTO(Location location){
        this.id = location.getId();
        this.name = location.getName();
        this.capacity = location.getCapacity();
        this.img = location.getImg();
    }

}