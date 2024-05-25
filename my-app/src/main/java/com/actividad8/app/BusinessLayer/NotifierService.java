package com.actividad8.app.BusinessLayer; 

import java.util.List;

public interface NotifierService 
{
    public void addNotification(Task task, String notification);
    public List<String> getNotifications(User user);
}