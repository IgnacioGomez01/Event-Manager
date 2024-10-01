package com.mindhub.event_manager.dtos;

import com.mindhub.event_manager.models.Comment;
import com.mindhub.event_manager.models.Event;
import com.mindhub.event_manager.models.EventLocation;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class EventDTO {

    private UUID eventId;
    private String name;
    private byte age_req;
    private String desc;
    private String img;
    private Set<Comment> comments = new HashSet<>();
    private Set<EventLocation> eventLocations = new HashSet<>();
    //private Customer customer;



    public EventDTO(Event event){
        this.eventId = event.getId();
        this.name = event.getName();
        this.age_req = event.getAge_req();
        this.desc = event.getDesc();
        this.img = event.getImg();
        //this.customer = event.getCustomer();
        this.comments = event.getComments();
        this.eventLocations = getEventLocations();
    }
}