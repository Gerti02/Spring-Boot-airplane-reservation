package com.example.airplane_reservation.Controller;

import com.example.airplane_reservation.Model.User;
import com.example.airplane_reservation.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userUpdate) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userUpdate.getName());
            user.setEmail(userUpdate.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}

