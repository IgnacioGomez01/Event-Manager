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

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID customer_id;

    private String name;
    private String lastname;
    private String email;
    private boolean activated;
    private String password;
    private short age;
    private CustomerGender gender;
    private CustomerRol rol;

    @OneToMany (mappedBy = "customer")
    private Set<Event> events = new HashSet<>();

    @OneToMany (mappedBy = "customer")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<CustomerEventLocation> customerEventLocations = new HashSet<>();

    public void addEvent(Event event){
        event.setCustomer(this);
        this.events.add(event);
    }

    public void addComment(Comment comment){
        comment.setCustomer(this);
        this.comments.add(comment);
    }

    public void addCustomerEvent(CustomerEventLocation customerEventLocation){
        customerEventLocation.setCustomer(this);
        this.customerEventLocations.add(customerEventLocation);
    }
}
