package com.alencar.events_microservice.services;

import com.alencar.events_microservice.repositories.EventRepository;
import com.alencar.events_microservice.repositories.SubscriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @Mock
    private SubscriptionRepository subscriptionRepository;

    @Mock
    private EmailServiceClient emailServiceClient;

    @Autowired
    @InjectMocks
    private EventService  eventService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create transaction successfully when everything is ok")
    void getAllEvents() {
    }
}