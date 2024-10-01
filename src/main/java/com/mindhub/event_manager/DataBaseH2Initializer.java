package com.mindhub.event_manager;

import com.mindhub.event_manager.models.*;
import com.mindhub.event_manager.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseH2Initializer {
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

            Users users1 = new Users();
            Organizer organizer1 = new Organizer();
            Event event1 = new Event();
            Comment comment1 = new Comment();
            Comment comment2 = new Comment();
            Location location1 = new Location();
            EventLocation eventLocation1 = new EventLocation();
            UserEventLocation userEventLocation1 = new UserEventLocation();

            users1.addCustomerEvent(userEventLocation1);
            users1.addComment(comment1);
            users1.addComment(comment2);

            organizer1.addEvent(event1);

            eventLocation1.addCustomerEvent(userEventLocation1);
            event1.addEventLocation(eventLocation1);
            event1.addComment(comment1);
            event1.addComment(comment2);
            location1.addEventLocation(eventLocation1);


            organizerRepository.save(organizer1);
            userRepository.save(users1); // Save AppUser first
            eventRepository.save(event1);
            locationRepository.save(location1);
            eventLocationRepository.save(eventLocation1);
            userEventLocationRepository.save(userEventLocation1);


            commentRepository.save(comment1); // Save comments after AppUser
            commentRepository.save(comment2);

        };
    }
}
