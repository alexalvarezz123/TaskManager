package com.actividad8.app.BusinessLayer; 

import java.util.ArrayList;
import java.util.List; 

public class Task 
{
    private String id; 
    private String name; 
    private Status status; 
    private List<String> messages; 

    public Task() {
        this.status = Status.PENDING;
        messages = new ArrayList<>();
    }
    
    public String getId() {return this.id;}
    
    public void setId(String id) {this.id = id;}
    
    public String getName() {return this.name;}
    
    public void setName(String name) {this.name = name;}
    
    public void finish() {this.status = Status.FINISHED;}
    
    public List<String> getNotifications() {return this.messages;}
}
enum Status {
    FINISHED, 
    PENDING
};