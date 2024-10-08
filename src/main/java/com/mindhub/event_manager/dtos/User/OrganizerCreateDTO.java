package com.mindhub.event_manager.dtos.User;

import com.mindhub.event_manager.enums.CustomerRol;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
public class OrganizerCreateDTO {

    private String name;
    private String lastname;
    private String email;
    private String password;
    private CustomerRol customerRol = CustomerRol.MANAGER;
    public void encodePassword (PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }

}
