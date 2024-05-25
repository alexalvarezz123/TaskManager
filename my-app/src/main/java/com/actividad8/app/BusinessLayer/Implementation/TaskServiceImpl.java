package com.actividad8.app.BusinessLayer.Implementation;

import java.util.List;

import com.actividad8.app.BusinessLayer.Task;
import com.actividad8.app.BusinessLayer.User;
import com.actividad8.app.BusinessLayer.NotifierService;
import com.actividad8.app.BusinessLayer.TaskService;
import com.actividad8.app.DataLayer.TaskRepository;

public class TaskServiceImpl implements TaskService
{
    private TaskRepository taskRepository; 
    private NotifierService notifierServive; 
    
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.notifierServive = new NotifierServiceImpl();
    }
    
    public void addTask(Task task) {
        taskRepository.addTask(task);
    }
    
    public Task getTask(String id) {
        return taskRepository.getTask(id);
    } 
    
    public List<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }
    
    public void addMember(Task task, User user) {
        user.addTask(task);
        notifierServive.addNotification(
            task, 
            user.getName()+" fue agregado al equipo"
        );
    }
    
    public void finish(Task task) {
        this.taskRepository.finish(task);
    }
}