package com.mindhub.event_manager.dtos.User;

import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.models.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
public class UserDTO {

    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private byte age;
    private CustomerGender gender;


    public UserDTO(Users users){
        this.id= users.getId();
        this.email= users.getEmail();
        this.name= users.getName();
        this.lastname= users.getName();
        this.age= users.getAge();
        this.gender= users.getGender();
    }
}