package com.example.implementation;

import com.example.interfaces.facade.model.EventInterface;
import com.example.interfaces.facade.model.TicketInterface;
import com.example.interfaces.facade.model.UserInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Storage implements ApplicationContextAware {

    private ApplicationContext context;
    private static final Logger logger = LoggerFactory.getLogger(Storage.class);
    private String dataFilePath;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void setDataFilePath(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    private ObjectMapper objectMapper = new ObjectMapper();

    public void initStorage() throws Exception {

        UserInterface userInterface = context.getBean("userService", UserInterface.class);
        EventInterface eventInterface = context.getBean("eventService", EventInterface.class);
        TicketInterface ticketInterface = context.getBean("ticketService", TicketInterface.class);

        if (dataFilePath != null) {
            try {
                Files.lines(Paths.get(dataFilePath)).forEach(line -> {
                    int colonIndex = line.indexOf(":");
                    if (colonIndex > 0) {
                        String key = line.substring(0, colonIndex).trim();
                        String value = line.substring(colonIndex + 1).trim();

                        if (key.startsWith("user")) {
                            try {
                                User user = objectMapper.readValue(value, User.class);
                                userInterface.createUser(user);
                                logger.info("Processed User Data: " + user);
                            } catch (JsonProcessingException e) {
                                logger.info("Incorrect User data", e);
                            }
                        } else if (key.startsWith("event")) {
                            try {
                                Event event = objectMapper.readValue(value, Event.class);
                                eventInterface.createEvent(event);
                                logger.info("Processed Event Data: " + event);
                            } catch (JsonProcessingException e) {
                                logger.info("Incorrect Event data", e);
                            }
                        } else if (key.startsWith("ticket")) {
                            try {
                                Ticket ticket = objectMapper.readValue(value, Ticket.class);
                                ticketInterface.bookTicket(ticket.getUserId(), ticket.getEventId(), ticket.getSeat());
                                logger.info("Processed Ticket Data: " + ticket);
                            } catch (JsonProcessingException e) {
                                logger.info("Incorrect Ticket data", e);
                            }
                        }
                    }
                });
            } catch (IOException e) {
                throw new RuntimeException("Error reading data from the file", e);
            }
        }
    }
}
