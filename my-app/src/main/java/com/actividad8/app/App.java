package com.actividad8.app;

import com.actividad8.app.BusinessLayer.TaskService;
import com.actividad8.app.BusinessLayer.User;
import com.actividad8.app.BusinessLayer.UserService;
import com.actividad8.app.BusinessLayer.Implementation.TaskServiceImpl;
import com.actividad8.app.BusinessLayer.Implementation.UserServiceImpl;
import com.actividad8.app.DataLayer.Implementation.TaskRepositoryImpl;
import com.actividad8.app.DataLayer.Implementation.UserRepositoryImpl;
import com.actividad8.app.PresentationLayer.TaskUI;

public class App 
{
    public static void main( String[] args )
    {
        TaskService taskService = new TaskServiceImpl(
            TaskRepositoryImpl.getInstance()
        );
        UserService userService = new UserServiceImpl(
            UserRepositoryImpl.getInstance()
        );
        addUsers(userService); 

        TaskUI taskUI = new TaskUI(userService, taskService);
        taskUI.init();
    }
    
    private static void addUsers(UserService userService) {
        String names[] = new String[]{
            "Alex", "Paola", "Jorge", "Deisy", "Pedro", "Jack", "Sara", "Victoria", "Alba", "Mario"
        }; 
        for (int i =0 ; i<10; i++) {
            User user = new User(); 
            user.setName(names[i]);
            userService.addUser(user);
        }
    }
}
