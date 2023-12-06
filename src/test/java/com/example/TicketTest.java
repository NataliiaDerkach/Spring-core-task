package com.example;

import com.example.interfaces.DemoApplication;
import com.example.interfaces.facade.model.EventInterface;
import com.example.interfaces.facade.model.TicketInterface;
import com.example.interfaces.facade.model.UserInterface;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTest {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Test
    public void ticketCreationTest() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TicketInterface ticketInterface = context.getBean("ticketService", TicketInterface.class);
        UserInterface userInterface = context.getBean("userService", UserInterface.class);
        EventInterface eventInterface = context.getBean("eventService", EventInterface.class);

        logger.info("Let's check booked tickets by User having ID 1: ");
        ticketInterface.getBookedTickets(userInterface.getUserById(1l)).forEach(System.out::println);

        logger.info("Let's check booked tickets by Event having ID 2: ");
       // ticketInterface.getBookedTickets(eventInterface.getEventById(2l)).forEach(System.out::println);

        logger.info("Let's add booked ticket for User having ID 1 on Event with ID 2 on seat 55: ");
        ticketInterface.bookTicket(1l, 2l, 55);

        assertEquals(ticketInterface.getBookedTickets(userInterface.getUserById(1l)).size(), 2);
        ticketInterface.getBookedTickets(userInterface.getUserById(1l)).forEach(System.out::println);
    }
}
