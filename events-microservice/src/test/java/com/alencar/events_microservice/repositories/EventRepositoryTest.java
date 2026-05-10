package com.alencar.events_microservice.repositories;

import com.alencar.events_microservice.domain.Event;
import com.alencar.events_microservice.dtos.EventRequestDTO;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
class EventRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    private EventRepository eventRepository;

    @Test
    @DisplayName("Should get Event successfully from DB")
    void findUpComingEventsCase1() {

        EventRequestDTO data = new EventRequestDTO(3, 1, "25/05/2026", "Teste Gabriel", "Validation teste J-UNIT");
        this.createEvent(data);

        LocalDateTime date = LocalDateTime.of(2026,5,3,0,0);
        List<Event> result = this.eventRepository.findUpComingEvents(date);
        assertThat(result).isNotEmpty();
    }

    @Test
    @DisplayName("Should not get Event from DB when Event not exists")
    void findUpComingEventsCase2() {
        LocalDateTime date = LocalDateTime.of(2026,5,3,0,0);
        List<Event> result = this.eventRepository.findUpComingEvents(date);
        assertThat(result.isEmpty()).isTrue();
    }


    @Test
    void findById() {
    }

    private Event createEvent(EventRequestDTO eventRequestDTO) {
     Event newEvent = new Event(eventRequestDTO);
     this.entityManager.persist(newEvent);
     return newEvent;
    }
}