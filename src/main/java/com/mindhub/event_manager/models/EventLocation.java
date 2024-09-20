package com.mindhub.event_manager.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class EventLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID eventLocation_id;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;
    @ManyToOne
    @JoinColumn(name="location_id")
    private Location location;

    @OneToMany(mappedBy = "eventLocation")
    private Set<CustomerEventLocation> customerEventLocations = new HashSet<>();

    private LocalDateTime date;
    private int assistance;

    public void addCustomerEvent(CustomerEventLocation customerEventLocation){
        customerEventLocation.setEventLocation(this);
        this.customerEventLocations.add(customerEventLocation);
    }

    public EventLocation(LocalDateTime date, int assistance) {
        this.date = date;
        this.assistance = assistance;
    }


}
