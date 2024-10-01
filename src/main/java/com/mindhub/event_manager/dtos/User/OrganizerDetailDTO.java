package com.mindhub.event_manager.dtos.User;

import com.mindhub.event_manager.models.Organizer;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class OrganizerDetailDTO {

    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private Set<EventSummaryDTO> events = new HashSet<>();

    public OrganizerDetailDTO(Organizer organizer){
        this.id = organizer.getId();
        this.name = organizer.getName();
        this.lastname = organizer.getLastname();
        this.email = organizer.getEmail();
        this.events = organizer.getEvents().stream().map(EventSummaryDTO::new).collect(Collectors.toSet());
    }

}
