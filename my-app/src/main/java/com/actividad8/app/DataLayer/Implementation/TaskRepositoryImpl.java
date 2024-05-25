package com.actividad8.app.DataLayer.Implementation;

import java.util.List;

import com.actividad8.app.BusinessLayer.Task;
import com.actividad8.app.DataLayer.TaskRepository;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class TaskRepositoryImpl implements TaskRepository
{
    private static TaskRepository taskRepository; 
    private Map<String, Task> map = new HashMap<>();
    private Map<String, Task> finishedTask = new HashMap<>(); 

    public static TaskRepository getInstance() {
        if (taskRepository != null) return taskRepository; 
        return taskRepository = new TaskRepositoryImpl();
    }
    
    public void addTask(Task task) {
        map.put(task.getId(), task);
    }
    
    public Task getTask(String id) {
        return map.get(id);
    }
    
    public void finish(Task task) {
        task.finish();
        map.remove(task.getId());
        finishedTask.put(task.getId(), task);
    }
    
    public List<Task> getAllTasks() {
        return new ArrayList<>(map.values());
    }
}