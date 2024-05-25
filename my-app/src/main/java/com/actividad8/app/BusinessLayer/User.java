package com.actividad8.app.BusinessLayer; 

import java.util.Set;
import java.util.HashSet;
 
public class User 
{
    private String name; 
    private Set<Task> tasks;
    
    public User() {
        tasks = new HashSet<>(); 
    } 
    
    public void addTask(Task task) {
        tasks.add(task); 
    }
    
    public Set<Task> getTasksAssigned() {
        return this.tasks;
    }
    
    public void setName(String name) {this.name = name;}
    
    public String getName() {return this.name;}
}