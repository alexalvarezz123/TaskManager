package com.actividad8.app.BusinessLayer;

import java.util.List;

public interface UserService 
{
    public void addUser(User user); 
    public User getUser(String id); 
    public List<User> getAllUsers(); 
}