package com.mindhub.event_manager.controllers;

import com.mindhub.event_manager.dtos.User.UserDTO;
import com.mindhub.event_manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private com.mindhub.event_manager.repositories.UserRepository UserRepository;


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
}
