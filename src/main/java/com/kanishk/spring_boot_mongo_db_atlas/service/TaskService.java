package com.kanishk.spring_boot_mongo_db_atlas.service;

import com.kanishk.spring_boot_mongo_db_atlas.model.Task;
import com.kanishk.spring_boot_mongo_db_atlas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    // CRUD operations

    // Create
    public Task addTask(Task task) {
        task.setId(UUID.randomUUID().toString());
        return repository.save(task);
    }

    // Read
    public List<Task> fetchAllTasks() {
        return repository.findAll();
    }

    public Task fetchTaskById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Task> fetchTaskBySeverity(Integer severity) {
        return repository.findBySeverity(severity);
    }

    public List<Task> fetchTaskByAssignee(String assignee) {
        return repository.getByAssignee(assignee);
    }

    // Update
    public Task updateTask(Task task, String id) {
        Task found = repository.findById(id).orElseThrow();
        if (task.getDescription() != null && !task.getDescription().isEmpty() && !task.getDescription().isBlank()) {
            found.setDescription(task.getDescription());
        }
        if (task.getAssignee() != null && !task.getAssignee().isEmpty() && !task.getAssignee().isBlank()) {
            found.setAssignee(task.getAssignee());
        }
        if (task.getPoint() != null) {
            found.setPoint(task.getPoint());
        }
        if (task.getSeverity() != null) {
            found.setSeverity(task.getSeverity());
        }
        return repository.save(found);
    }

    // Delete
    public String deleteTask(String id) {
        repository.deleteById(id);
        return "Deletion successful for ID : " + id;
    }
}
