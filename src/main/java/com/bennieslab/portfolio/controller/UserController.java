package com.bennieslab.portfolio.controller;

import com.bennieslab.portfolio.model.UserPublicDto;
import com.bennieslab.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserPublicDto> getUserByEmail(@PathVariable String email) {
        Optional<UserPublicDto> userDtoOptional = userService.getUserByEmail(email);
        return userDtoOptional.map(userPublicDto -> ResponseEntity.ok().body(userPublicDto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
