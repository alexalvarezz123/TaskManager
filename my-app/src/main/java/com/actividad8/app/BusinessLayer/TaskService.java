package com.actividad8.app.BusinessLayer; 

import java.util.List;

public interface TaskService 
{
    public void addTask(Task task);
    public Task getTask(String id); 
    public List<Task> getAllTasks(); 
    public void finish(Task task);
    public void addMember(Task task, User user); 
}