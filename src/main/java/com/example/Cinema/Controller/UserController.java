package com.example.Cinema.Controller;

import com.example.Cinema.Model.Movie;
import com.example.Cinema.Model.User;
import com.example.Cinema.Repository.UserRepository;
import com.example.Cinema.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@RequestBody User user){
        return new ResponseEntity<>(userService.register(user), HttpStatus.OK);
    }
}
