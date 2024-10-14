package com.mindhub.event_manager.models;

import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.enums.CustomerRol;
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
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String lastname;
    private String email;
    private boolean activated = true;
    private String password;
    private CustomerRol rol;

    public Customer(String name, String lastname, String email, String password, CustomerRol rol) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
}
