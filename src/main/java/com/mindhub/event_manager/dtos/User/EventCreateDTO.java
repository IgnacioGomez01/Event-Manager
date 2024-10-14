package com.mindhub.event_manager.dtos.User;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
public class EventCreateDTO {

    private UUID organizerId;
    private String name;
    private byte age_req;
    private String desc;
    private String img;

}