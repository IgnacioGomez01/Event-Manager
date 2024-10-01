package com.mindhub.event_manager.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class UserEventLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID customerEventId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users users;

    @ManyToOne
    @JoinColumn (name="eventLocation_id")
    private EventLocation eventLocation;


}
