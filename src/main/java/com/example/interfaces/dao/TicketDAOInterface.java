package com.example.interfaces.dao;

import com.example.implementation.Event;
import com.example.implementation.Ticket;
import com.example.implementation.User;

import java.util.List;

public interface TicketDAOInterface {

    Ticket bookTicket(long userId, long eventId, int seat);
    void cancelTicket(long ticketId);
    List<Ticket> getBookedTickets(User user);
    List<Ticket> getBookedTickets(Event event);

}
