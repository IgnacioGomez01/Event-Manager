package com.mindhub.event_manager.models;

import com.mindhub.event_manager.enums.CustomerRol;
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

    public Organizer(String ignacio, String perez, String mail, String encode, CustomerRol customerRol) {
    }

    public void addEvent(Event event){
        event.setOrganizer(this);
        this.events.add(event);
    }
}
