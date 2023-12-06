package com.example.implementation.services;

import com.example.implementation.Event;
import com.example.implementation.Ticket;
import com.example.implementation.User;
import com.example.interfaces.dao.TicketDAOInterface;
import com.example.interfaces.facade.model.TicketInterface;

import java.util.List;

public class TicketServiceImpl implements TicketInterface {

    private TicketDAOInterface ticketDAO;

    public TicketServiceImpl(TicketDAOInterface ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int seat) {
        return ticketDAO.bookTicket(userId, eventId, seat);
    }

    @Override
    public void cancelTicket(long ticketId) {
        ticketDAO.cancelTicket(ticketId);
    }

    @Override
    public List<Ticket> getBookedTickets(User user) {
        return ticketDAO.getBookedTickets(user);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event) {
        return ticketDAO.getBookedTickets(event);
    }
}
