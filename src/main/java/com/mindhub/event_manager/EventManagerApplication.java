package com.mindhub.event_manager;

import com.mindhub.event_manager.models.*;
import com.mindhub.event_manager.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventManagerApplication {

	public static void main(String[] args) {SpringApplication.run(EventManagerApplication.class, args);

	}
}
