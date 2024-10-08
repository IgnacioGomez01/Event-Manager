package com.mindhub.event_manager.models;


import com.mindhub.event_manager.enums.CustomerGender;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Users extends Customer {

    private byte age;
    private CustomerGender gender;

    @OneToMany(mappedBy = "users")
    private Set<Comment> comments = new HashSet<>();

    @OneToMany(mappedBy = "users")
    private Set<UserEventLocation> userEventLocations = new HashSet<>();

    public void addComment(Comment comment){
        comment.setUsers(this);
        this.comments.add(comment);
    }

    public void addCustomerEvent(UserEventLocation userEventLocation){
        userEventLocation.setUsers(this);
        this.userEventLocations.add(userEventLocation);
    }


}

