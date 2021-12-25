package com.ibrahimtkk.thirdhomework.controller;

import com.ibrahimtkk.thirdhomework.converter.UserConverter;
import com.ibrahimtkk.thirdhomework.dto.UserDto;
import com.ibrahimtkk.thirdhomework.entity.User;
import com.ibrahimtkk.thirdhomework.entityservice.UserEntityService;
import com.ibrahimtkk.thirdhomework.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @GetMapping("")
    public List<UserDto> findAllUsers() {

        List<User> users = userEntityService.findAll();

        return users.stream()
                .map((User user) -> UserConverter.INSTANCE.toUserDto(user))
                .collect(Collectors.toList());
    }

    @GetMapping("/{userId}")
    public UserDto findByUserId(@PathVariable String userId) {
        UserDto userDto = userEntityService.findById(userId);
        if (userDto == null)
            throw new UserNotFoundException("User not found by username. username: " + userId);
        return userDto;
    }

    @PostMapping("")
    public UserDto save(@RequestBody UserDto userDto) { //TODO: Input değeri dto tipinde olmalı

        userDto = userEntityService.save(userDto);
        return userDto;
    }

    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable String userId) {
        userEntityService.deleteById(userId);
    }

}
