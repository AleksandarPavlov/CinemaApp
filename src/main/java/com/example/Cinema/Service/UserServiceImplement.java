package com.example.Cinema.Service;

import com.example.Cinema.Model.User;
import com.example.Cinema.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User register(User user) {
        List<User> allUsers = userRepository.findAll();
        for(User x : allUsers){
            if(x.getUsername().equals(user.getUsername())){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already exists: " + user.getUsername());

            }
        }
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }
}
