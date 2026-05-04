package com.alencar.events_microservice.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema
public record EventRequestDTO( int maxParticipants, int registeredParticipants, String date, String title, String description) {
}
