package com.example.Cinema.Service;

import com.example.Cinema.Model.User;

public interface UserService {
    public User register(User user);
    public User findByUsername(String username);
}
