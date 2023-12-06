package com.example;

import com.example.implementation.Event;
import com.example.interfaces.DemoApplication;
import com.example.interfaces.facade.model.EventInterface;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Test
    public void createNewEvent() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EventInterface eventInterface = context.getBean("eventService", EventInterface.class);

        logger.info("Let's check existed events: ");
        eventInterface.getAllEvents().forEach(System.out::println);

        logger.info("Let's create new event: ");
        eventInterface.createEvent(new Event(333l, "Dance for kids", "Kids Worlds, 114 Avenu"));
        eventInterface.getAllEvents().forEach(System.out::println);

        logger.info("Let's update the event having ID #1: ");

       // String previousName = eventInterface.getEventById(1l).getTitle();
       // String previousLocation = eventInterface.getEventById(1l).getLocation();

        eventInterface.updateEvent(new Event(1l, "Updated Event Name", "Updated Event Location"));

        String updatedName = eventInterface.getEventById(1l).getTitle();
        String updatedLocation = eventInterface.getEventById(1l).getLocation();

        assertEquals("Updated Event Name", updatedName);
        assertEquals("Updated Event Location", updatedLocation);

        eventInterface.getAllEvents().forEach(System.out::println);

    }
}
