package com.esveidy.taskmanager.Service;

import com.esveidy.taskmanager.Entity.Task;
import com.esveidy.taskmanager.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    // obtener todas las tareas
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Obtener tarea por ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Crear nueva tarea
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Eliminar tarea
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Marcar como completada
    public Task completeTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task no encontrada"));

        task.setCompleted(true);
        return taskRepository.save(task);
    }
}
