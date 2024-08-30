package com.kanishk.spring_boot_mongo_db_atlas.controller;

import com.kanishk.spring_boot_mongo_db_atlas.model.Task;
import com.kanishk.spring_boot_mongo_db_atlas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return service.addTask(task);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return service.fetchTaskById(id);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.fetchAllTasks();
    }

    @GetMapping("/severity/{severity}")
    public List<Task> getTasksBySeverity(@PathVariable Integer severity) {
        return service.fetchTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTasksByAssignee(@PathVariable String assignee) {
        return service.fetchTaskByAssignee(assignee);
    }

    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable String id) {
        return service.updateTask(task, id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {
        return service.deleteTask(id);
    }

}
