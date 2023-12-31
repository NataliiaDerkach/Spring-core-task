package com.example.implementation.dao;

import com.example.implementation.Event;
import com.example.implementation.Ticket;
import com.example.implementation.User;
import com.example.interfaces.dao.TicketDAOInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketDAO implements TicketDAOInterface {

    private final Map<Long, Ticket> ticketMap = new HashMap<>();
    private long currentId = 1;

    @Override
    public Ticket bookTicket(long userId, long eventId, int seat) {
        Ticket ticket = new Ticket(currentId, userId, eventId, seat);
        ticketMap.put(currentId, ticket);
        currentId++;
        return ticket;
    }

    @Override
    public void cancelTicket(long ticketId) {
        if (ticketMap.containsKey(ticketId)) {
            ticketMap.remove(ticketId);
        } else {
            throw new IllegalArgumentException("Ticket not found, try again");
        }
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        List<Ticket> userTickets = new ArrayList<>();
        for (Ticket ticket : ticketMap.values()) {
            if (ticket.getUserId() == user.getId()) {
                userTickets.add(ticket);
            }
        }
        return userTickets;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event) {
        List<Ticket> eventTickets = new ArrayList<>();
        for (Ticket ticket : ticketMap.values()) {
            if (ticket.getEventId() == event.getId()) {
                eventTickets.add(ticket);
            }
        }
        return eventTickets;
    }
}
