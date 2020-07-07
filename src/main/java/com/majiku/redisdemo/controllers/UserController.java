package com.majiku.redisdemo.controllers;

import com.majiku.redisdemo.models.User;
import com.majiku.redisdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/users")
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public Map<String, User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/all/{id}")
    public User findById(@PathVariable("id") final String id) {
        return userRepository.findById(id);
    }

    @PostMapping("/add")
    public User add(@RequestBody User user) {
        userRepository.save(new User(user.getId(), user.getName(), user.getScore()));
        return userRepository.findById(user.getId());
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        userRepository.update(new User(user.getId(), user.getName(), user.getScore()));
        return userRepository.findById(user.getId());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") final String id) {
        userRepository.delete(id);
    }
}
