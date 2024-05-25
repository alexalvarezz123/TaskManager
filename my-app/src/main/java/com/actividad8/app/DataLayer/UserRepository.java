package com.actividad8.app.DataLayer; 

import com.actividad8.app.BusinessLayer.User;

import java.util.List; 

public interface UserRepository 
{
    public User getUser(String id);    
    public List<User> getAllUsers(); 
    public void addUser(User user);
}