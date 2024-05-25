package com.actividad8.app.BusinessLayer.Implementation;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import com.actividad8.app.BusinessLayer.NotifierService;
import com.actividad8.app.BusinessLayer.Task;
import com.actividad8.app.BusinessLayer.User;

public class NotifierServiceImpl implements NotifierService 
{
    public void addNotification(Task task, String notification) {
        task.getNotifications().add(notification);
    }
    
    public List<String> getNotifications(User user) {
        List<String> notifications = new ArrayList<>(); 
        Iterator<Task> it = user.getTasksAssigned().iterator();
        while (it.hasNext()) {
            Task task = it.next();
            for (String notification: task.getNotifications())
                notifications.add(notification);
        }
        return notifications; 
    }
}