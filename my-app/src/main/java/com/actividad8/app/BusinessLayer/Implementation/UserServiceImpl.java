package com.actividad8.app.BusinessLayer.Implementation;

import java.util.List;

import com.actividad8.app.BusinessLayer.User;
import com.actividad8.app.BusinessLayer.UserService;
import com.actividad8.app.DataLayer.UserRepository;

public class UserServiceImpl implements UserService 
{
    private UserRepository userRepository; 
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository; 
    }
    public void addUser(User user) {
        userRepository.addUser(user);
    } 
    public User getUser(String id) {
        return userRepository.getUser(id);
    } 
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}