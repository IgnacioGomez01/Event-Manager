package com.mindhub.event_manager.repositories;

import com.mindhub.event_manager.models.CustomerEventLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEventLocationRepository extends JpaRepository<CustomerEventLocation,Long> {
}
