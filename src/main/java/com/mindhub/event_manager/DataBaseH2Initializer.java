package com.mindhub.event_manager;

import com.mindhub.event_manager.enums.CustomerGender;
import com.mindhub.event_manager.enums.CustomerRol;
import com.mindhub.event_manager.models.*;
import com.mindhub.event_manager.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DataBaseH2Initializer {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData(
            UserRepository userRepository,
            OrganizerRepository organizerRepository,
            CommentRepository commentRepository,
            UserEventLocationRepository userEventLocationRepository,
            EventRepository eventRepository,
            EventLocationRepository eventLocationRepository,
            LocationRepository locationRepository) {
        return args -> {
            // Initialize entities
            passwordEncoder.encode("1234");
            Users appUser1 = new Users("Luis","Gonzales","luis@gmail.com",passwordEncoder.encode("1234"), CustomerRol.USER, (byte) 20, CustomerGender.MALE);
            Organizer organizer1 = new Organizer("Ignacio","Perez","organizer@gmail.com",passwordEncoder.encode("1234"),CustomerRol.MANAGER);
            Organizer organizer2 = new Organizer("Facundo","Gomez","organizer2@gmail.com",passwordEncoder.encode("1234"),CustomerRol.MANAGER);
            Organizer admin1 = new Organizer("Maria","Edith","admin@gmail.com",passwordEncoder.encode("1234"),CustomerRol.ADMIN);
            Event event1 = new Event();
            Comment comment1 = new Comment();
            Comment comment2 = new Comment();
            Location location1 = new Location();
            EventLocation eventLocation1 = new EventLocation();
            UserEventLocation userEventLocation1 = new UserEventLocation();

            // Establish relationships
            appUser1.addCustomerEvent(userEventLocation1);
            appUser1.addComment(comment1);
            appUser1.addComment(comment2);

            organizer1.addEvent(event1);

            eventLocation1.addCustomerEvent(userEventLocation1);
            event1.addEventLocation(eventLocation1);
            event1.addComment(comment1);
            event1.addComment(comment2);
            location1.addEventLocation(eventLocation1);

            // Save related entities in the correct order
            organizerRepository.save(organizer1);
            userRepository.save(appUser1); // Save AppUser first
            organizerRepository.save(admin1);
            eventRepository.save(event1);
            locationRepository.save(location1);
            eventLocationRepository.save(eventLocation1);
            userEventLocationRepository.save(userEventLocation1);

            commentRepository.save(comment1); // Save comments after AppUser
            commentRepository.save(comment2);

        };
    }
}
