package com.mindhub.event_manager.dtos.User;

import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.enums.CustomerRol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {
    private String name;
    private String lastname;
    private String email;
    private byte age;
    private CustomerGender gender;
    private String password;
    private CustomerRol customerRol = CustomerRol.USER;

    public void encodePassword (PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }
}
