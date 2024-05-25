package com.actividad8.app.DataLayer;

import com.actividad8.app.BusinessLayer.Task;

import java.util.List;

public interface TaskRepository 
{
    public void addTask(Task task);
    public Task getTask(String id); 
    public List<Task> getAllTasks(); 
    public void finish(Task task);
}