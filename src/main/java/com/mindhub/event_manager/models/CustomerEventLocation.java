package com.mindhub.event_manager.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CustomerEventLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID customerEvent_id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Users users;

    @ManyToOne
    @JoinColumn (name="eventLocation_id")
    private EventLocation eventLocation;


}
