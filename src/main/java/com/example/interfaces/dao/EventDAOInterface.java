package com.example.interfaces.dao;

import com.example.implementation.Event;

import java.util.List;

public interface EventDAOInterface {

    Event createEvent(Event event);

    Event getEventById(long eventId);

    List<Event> getAllEvents();

    void updateEvent(Event event);

    void deleteEvent(long eventId);
}
