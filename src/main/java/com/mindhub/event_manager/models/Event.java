package com.mindhub.event_manager.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID event_id;

    private String name;
    private short age_req;
    private String desc;
    private String img;

    @ManyToOne
    @JoinColumn(name ="organizer_id")
    private Customer customer;

    @OneToMany(mappedBy = "event")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<EventLocation> eventLocations = new HashSet<>();


    public void addComment(Comment comment){
        comment.setEvent(this);
        this.comments.add(comment);
    }

    public void addEventLocation(EventLocation eventLocation) {
        eventLocation.setEvent(this);
        this.eventLocations.add(eventLocation);
    }

    public Event(String name, short age_req, String desc, String img) {
        this.name = name;
        this.age_req = age_req;
        this.desc = desc;
        this.img = img;
    }

}
