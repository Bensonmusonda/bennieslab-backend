package com.bennieslab.portfolio.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bennieslab.portfolio.model.User;
import com.bennieslab.portfolio.controller.UserController;

import java.util.List;

@Component
public class UserTestRunner implements CommandLineRunner {
    private final UserController userController;

    public UserTestRunner(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void run(String... args) throws Exception {
        
        List<User> users = userController.getAllUsers();

        
        if (users.isEmpty()) {
            System.out.println("No users found in the database.");
        } else {
            users.forEach(user -> System.out.println(user.getEmail()));
        }
    }
}

