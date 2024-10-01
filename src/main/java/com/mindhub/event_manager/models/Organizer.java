package com.mindhub.event_manager.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Organizer extends Customer{

    @OneToMany(mappedBy = "organizer")
    private Set<Event> events = new HashSet<>();

    public void addEvent(Event event){
        event.setOrganizer(this);
        this.events.add(event);
    }
}
