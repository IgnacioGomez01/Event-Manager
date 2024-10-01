package com.mindhub.event_manager.dtos.User;

import com.mindhub.event_manager.models.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class EventSummaryDTO {

    private UUID id;
    private String name;
    private byte age_req;
    private String desc;
    private String img;

    public EventSummaryDTO(Event event){
        this.id = event.getId();
        this.name = event.getName();
        this.age_req = event.getAge_req();
        this.desc = event.getDesc();
        this.img = event.getImg();
    }
}
