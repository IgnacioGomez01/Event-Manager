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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID comment_id;

    private String comment;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name ="event_id")
    private Event event;

}
