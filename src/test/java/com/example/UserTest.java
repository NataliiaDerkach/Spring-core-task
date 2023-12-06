package com.example;

import com.example.implementation.User;
import com.example.interfaces.DemoApplication;
import com.example.interfaces.facade.model.UserInterface;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    @Test
    public void CreateNewUserTest() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserInterface userInterface = context.getBean("userService", UserInterface.class);

        userInterface.getAllUsers().forEach(System.out::println);
        userInterface.createUser(new User(555l, "Elvis Presley", "Elvis555@example.com"));
        userInterface.getAllUsers().forEach(System.out::println);

        String lastAddedUser =  userInterface.getAllUsers().get(userInterface.getAllUsers().size() - 1).getName();

        logger.info("The user added in the end of map");

        assertEquals("Elvis Presley", lastAddedUser);
        userInterface.getAllUsers().forEach(System.out::println);

        Long userToUpdateId = userInterface.getAllUsers().get(userInterface.getAllUsers().size() - 1).getId();

        logger.info("Let's change his email and name (his ID now is {}):", userToUpdateId);

        User userToUpdate = new User(userToUpdateId, "Updated User Name", "updated_email@test.com");
        userInterface.updateUser(userToUpdate);
        logger.info("User with ID {} is updated.", userToUpdateId);
        userInterface.getAllUsers().forEach(System.out::println);

        context.close();
    }
}
