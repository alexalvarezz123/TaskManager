package com.actividad8.app.PresentationLayer;

import java.util.Scanner;

import com.actividad8.app.BusinessLayer.*;
import com.actividad8.app.BusinessLayer.Implementation.NotifierServiceImpl;

public class TaskUI
{
    private final Scanner sc = new Scanner(System.in);

    private UserService userService; 
    private TaskService taskService; 
    private NotifierService notifierService; 

    public TaskUI(UserService userService, TaskService taskService) {
        this.userService = userService; 
        this.taskService = taskService; 
        notifierService = new NotifierServiceImpl();
    }

    public void init() {
        String options[] = new String[]{
            "New Task", 
            "Finish Task", 
            "View Mail Manager", 
            "Exit"
        };
        int n = options.length; 
        while (true) {
            for (int i=1; i<=n; i++) 
                System.out.println(i+". "+options[i-1]); 
            int option = sc.nextInt(); 
            if (option==n) {
                System.out.println("Good Bye! :D"); 
                break;
            }
            switch (option) {
                case 1:
                    addTask(); 
                    break;
                case 2: 
                    finishTask();
                    break; 
                case 3: 
                    showMailManager(); 
                    break;
                default:
                    System.out.println("Write a available option.");
            }
        }
        sc.close();
    }
    public void addTask() {
        Task task = new Task();
        notifierService.addNotification(
            task, 
            "Se creo la tarea"
        );
        
        System.out.println("Enter its ID(must be unique): ");
        task.setId(sc.next());
        notifierService.addNotification(
            task, 
            "Se agrego el ID: "+task.getId()
        );
        
        System.out.print("Enter task name: "); 
        task.setName(sc.next());
        notifierService.addNotification(
            task, 
            "Se agrego el nombre: "+task.getName()
        );
        
        while (true) {
            int option = showListUsers();
            if (option == -1) break; 
            this.taskService.addMember(
                task, 
                this.userService.getAllUsers().get(option)
            );
        }
        this.taskService.addTask(task);
        System.out.println("Task created: "+task.getId());
    }
    public void finishTask() {
        System.out.println("List of all task: "); 
        for (Task task: this.taskService.getAllTasks()) 
            System.out.println(task.getId()+". "+task.getName()); 
        System.out.println("Exit"); 
            
        System.out.print("Enter an option: ");
        String option = sc.next();
        if (option.equals("Exit")) return;
        
        Task task = this.taskService.getTask(option); 
        notifierService.addNotification(
            task, 
            "Se finalizo la tarea: "+task.getName()
        );
        taskService.finish(task);
    }
    public void showMailManager() {
        int option = showListUsers(); 
        User user = userService.getAllUsers().get(option);
        for (String notification: notifierService.getNotifications(user))
            System.out.println(notification);        
    }; 
    public int showListUsers() {
        System.out.println("List of members: ");
        int i = 0;  
        for (User user: userService.getAllUsers())  
            System.out.println((i++)+". "+user.getName()); 
        System.out.println(-1+". End "); 
        
        System.out.print("Enter an option: ");
        return sc.nextInt();
    }

}