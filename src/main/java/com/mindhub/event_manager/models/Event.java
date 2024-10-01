package com.mindhub.event_manager.models;

import com.mindhub.event_manager.dtos.User.EventCreateDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Event{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private byte age_req;
    private String desc;
    private String img;

    @ManyToOne
    @JoinColumn(name ="organizer_id")
    private Organizer organizer;

    @OneToMany(mappedBy = "event")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "event")
    private Set<EventLocation> eventLocations = new HashSet<>();


    //Constructors
    public Event(EventCreateDTO eventCreateDTO, Organizer organizer){
        this.name = eventCreateDTO.getName();
        this.age_req = eventCreateDTO.getAge_req();
        this.desc = eventCreateDTO.getDesc();
        this.img = eventCreateDTO.getImg();
        this.organizer = organizer;
    }


    public void addComment(Comment comment){
        this.comments.add(comment);
    }

    public void addEventLocation(EventLocation eventLocation) {
        eventLocation.setEvent(this);
        this.eventLocations.add(eventLocation);
    }


}
