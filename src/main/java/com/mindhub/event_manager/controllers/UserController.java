package com.mindhub.event_manager.controllers;

import com.mindhub.event_manager.dtos.User.UserCreateDTO;
import com.mindhub.event_manager.dtos.User.UserDTO;
import com.mindhub.event_manager.models.Users;
import com.mindhub.event_manager.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private com.mindhub.event_manager.repositories.UserRepository UserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getListDTO(){
        List<UserDTO> list=UserRepository.findAll().stream().filter(a->a.isActivated()).map(UserDTO::new).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable UUID id) {
        return UserRepository.findById(id)
                .map(User -> ResponseEntity.ok(new UserDTO(User))) // Return 200 OK with DTO
                .orElse(ResponseEntity.notFound().build());               // Return 404 if not found
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        userCreateDTO.encodePassword(passwordEncoder);
        User user = new Users(userCreateDTO);
        User savedUser = UserRepository.save(user);
        return new ResponseEntity<>(new UserDTO((Users) savedUser), HttpStatus.CREATED);
    }


}
