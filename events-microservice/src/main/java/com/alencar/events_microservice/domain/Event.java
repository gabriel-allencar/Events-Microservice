package com.alencar.events_microservice.domain;
import com.alencar.events_microservice.dtos.EventRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "event")
@Entity(name = "event")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private int maxParticipants;
    private int registeredParticipants;
    private String date;
    private String title;
    private String description;

    public Event (EventRequestDTO eventRequestDTO){
    this.date =  eventRequestDTO.date();
    this.title = eventRequestDTO.title();
    this.description = eventRequestDTO.description();
    this.maxParticipants = eventRequestDTO.maxParticipants();
    this.registeredParticipants = eventRequestDTO.registeredParticipants();
    }
}
