package com.alencar.events_microservice.controllers;

import com.alencar.events_microservice.domain.Event;
import com.alencar.events_microservice.domain.Subscription;
import com.alencar.events_microservice.dtos.EventRequestDTO;
import com.alencar.events_microservice.dtos.SubscriptionRequestDTO;
import com.alencar.events_microservice.services.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Eventos", description = "Edpoints de eventos")
@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Operation(summary = "Listar todos os eventos")
    @GetMapping
    public List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/upcomig")
    public List<Event> getUpcomigEvents(){
        return eventService.getUpcomingEvents();
    }

    @PostMapping
    public Event createEvent(@RequestBody EventRequestDTO event){
        return eventService.createEvent(event);
    }

    @PostMapping("/{eventId}/register")
    public void registerParticipant(@PathVariable String eventId, @RequestBody SubscriptionRequestDTO subscriptionDTO){
        eventService.registerParticipant(eventId, subscriptionDTO.participantEmail());
    }
}
