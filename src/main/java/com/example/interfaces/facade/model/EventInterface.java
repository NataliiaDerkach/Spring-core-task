package com.example.interfaces.facade.model;

import com.example.implementation.Event;

import java.util.List;

public interface EventInterface {

    Event createEvent(Event event);

    Event getEventById(Long eventId);

    List<Event> getAllEvents();

    void updateEvent(Event event);

    void deleteEvent(Long eventId);
}
