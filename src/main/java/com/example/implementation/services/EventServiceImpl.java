package com.example.implementation.services;

import com.example.implementation.Event;
import com.example.interfaces.dao.EventDAOInterface;
import com.example.interfaces.facade.model.EventInterface;


import java.util.List;

public class EventServiceImpl implements EventInterface {

    private EventDAOInterface eventDAO;

    public EventServiceImpl(EventDAOInterface eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    public Event createEvent(Event event) {
        return eventDAO.createEvent(event);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventDAO.getEventById(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDAO.getAllEvents();
    }

    @Override
    public void updateEvent(Event event) {
        eventDAO.updateEvent(event);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventDAO.deleteEvent(eventId);
    }
}
