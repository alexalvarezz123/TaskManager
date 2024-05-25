package com.actividad8.app.DataLayer.Implementation;

import java.util.List;

import com.actividad8.app.BusinessLayer.User;
import com.actividad8.app.DataLayer.UserRepository;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class UserRepositoryImpl implements UserRepository 
{
    private static UserRepositoryImpl userRepository; 
    private Map<String,User> map = new HashMap<>();
    
    public static UserRepositoryImpl getInstance() {
        if (userRepository != null) return userRepository; 
        return userRepository = new UserRepositoryImpl();
    }
    
    public User getUser(String id) {
        return map.get(id); 
    }
    
    public List<User> getAllUsers() {
        return new ArrayList<>(map.values());
    }
    
    public void addUser(User user) {
        map.put(user.getName(), user);
    }

}