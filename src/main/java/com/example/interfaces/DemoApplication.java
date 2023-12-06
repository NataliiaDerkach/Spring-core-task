package com.example.interfaces;

import com.example.implementation.User;
import com.example.interfaces.facade.model.EventInterface;
import com.example.interfaces.facade.model.TicketInterface;
import com.example.interfaces.facade.model.UserInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class DemoApplication {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserInterface userInterface = context.getBean("userService", UserInterface.class);
        EventInterface eventInterface = context.getBean("eventService", EventInterface.class);
        TicketInterface ticketInterface = context.getBean("ticketService", TicketInterface.class);

        userInterface.getAllUsers().forEach(System.out::println);
        eventInterface.getAllEvents().forEach(System.out::println);

        Long userToUpdateId = 1l;

        User userToUpdate = new User(userToUpdateId, "Updated User Name", "updated_email@test.com");
        userInterface.updateUser(userToUpdate);
        logger.info("User with ID {} is updated.");
        userInterface.getAllUsers().forEach(System.out::println);

        context.close();
    }
}
