package com.example.interfaces.facade.model;

import com.example.implementation.Event;
import com.example.implementation.Ticket;
import com.example.implementation.User;

import java.util.List;

public interface TicketInterface {

    Ticket bookTicket(long userId, long eventId, int seat);

    void cancelTicket(long ticketId);

    List<Ticket> getBookedTickets(User user);

    List<Ticket> getBookedTickets(Event event);
}
