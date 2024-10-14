package com.mindhub.event_manager.models;

import com.mindhub.event_manager.dtos.User.OrganizerCreateDTO;
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

    @OneToMany (mappedBy = "organizer")
    private Set<Event> events = new HashSet<>();

    public Organizer(OrganizerCreateDTO organizerCreateDTO){
        super(organizerCreateDTO.getName(), organizerCreateDTO.getLastname(), organizerCreateDTO.getEmail(), organizerCreateDTO.getPassword(), organizerCreateDTO.getCustomerRol());
    }
    public Organizer(String name, String lastname, String email, String password, CustomerRol rol) {
        super(name, lastname, email, password, rol);
    }

    public void addEvent(Event event){
        event.setOrganizer(this);
        this.events.add(event);
    }
}
