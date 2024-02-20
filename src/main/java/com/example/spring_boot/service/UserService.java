package com.example.spring_boot.service;

import com.example.spring_boot.model.User;
import com.example.spring_boot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        log.info("Getting user by id: {}", id);
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public List<User> findAll() {
        log.info("Getting all users");
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        log.info("Saving user: {}", user);
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        log.info("Updating user with id {}: {}", id, user);
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        log.info("Deleting user by id {} ", id);
        userRepository.deleteById(id);
    }
}
