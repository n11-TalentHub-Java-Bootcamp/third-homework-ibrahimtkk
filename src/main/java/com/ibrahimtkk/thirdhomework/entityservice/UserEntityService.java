package com.ibrahimtkk.thirdhomework.entityservice;

import com.ibrahimtkk.thirdhomework.converter.UserConverter;
import com.ibrahimtkk.thirdhomework.dto.UserDto;
import com.ibrahimtkk.thirdhomework.entity.User;
import com.ibrahimtkk.thirdhomework.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserEntityService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserDto findById(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return UserConverter.INSTANCE.toUserDto(user);
        }
        return null;
    }

    public UserDto save(UserDto userDto) {
        User user = UserConverter.INSTANCE.toUser(userDto);
        User savedUser = userRepository.save(user);
        return UserConverter.INSTANCE.toUserDto(savedUser);
    }

    public void deleteById(String userId) {
        userRepository.deleteById(userId);
    }

}