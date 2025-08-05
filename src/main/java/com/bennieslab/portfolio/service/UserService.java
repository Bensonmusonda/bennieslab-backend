package com.bennieslab.portfolio.service;

import com.bennieslab.portfolio.model.User;
import com.bennieslab.portfolio.model.UserPublicDto;
import com.bennieslab.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserPublicDto> getUserByEmail(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);

        return userOptional.map(user -> new UserPublicDto(
                user.getFirstName(),
                user.getLastName(),
                user.getCareer(),
                user.getLocation()
        ));
    }
}
