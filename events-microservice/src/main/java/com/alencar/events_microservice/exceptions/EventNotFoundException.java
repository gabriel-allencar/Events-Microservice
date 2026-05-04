package com.alencar.events_microservice.exceptions;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(){
        super("evento não encontrado");
    }

    public EventNotFoundException (String message) {
        super(message);
    }
}
