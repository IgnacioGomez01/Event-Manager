package com.mindhub.event_manager.dtos.User;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class EventCreateDTO {

    private String name;
    private byte age_req;
    private String desc;
    private String img;

}