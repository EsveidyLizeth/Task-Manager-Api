package com.esveidy.taskmanager.Controller;

import com.esveidy.taskmanager.Entity.Task;
import com.esveidy.taskmanager.Service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {
    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // get listar tareas
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // get por ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .orElseThrow(() -> new RuntimeException("Task no encontrada"));
    }

    // post crear tarea
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    // delete eliminar tarea
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    // put completar tarea
    @PutMapping("/{id}/complete")
    public Task completeTask(@PathVariable Long id) {
        return taskService.completeTask(id);
    }
}
