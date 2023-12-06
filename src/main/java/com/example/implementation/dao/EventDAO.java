package com.example.implementation.dao;

import com.example.implementation.Event;
import com.example.interfaces.dao.EventDAOInterface;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventDAO implements EventDAOInterface {

    private final Map<Long, Event> eventMap = new HashMap<>();
    private long currentId = 1;

    @Override
    public Event createEvent(Event event) {
        event.setId(currentId);
        eventMap.put(currentId, event);
        currentId++;
        return event;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventMap.get(eventId);
    }

    @Override
    public List<Event> getAllEvents() {
        return Collections.unmodifiableList(eventMap.values()
                .stream()
                .collect(Collectors.toList()));
    }

    @Override
    public void updateEvent(Event event) {
        if (eventMap.containsKey(event.getId())) {
            eventMap.put(event.getId(), event);
        } else {
            throw new IllegalArgumentException("Event not found, try again");
        }
    }

    @Override
    public void deleteEvent(long eventId) {
        eventMap.remove(eventId);
    }
}
