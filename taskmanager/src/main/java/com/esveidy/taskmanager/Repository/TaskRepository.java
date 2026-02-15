package com.esveidy.taskmanager.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.esveidy.taskmanager.Entity.Task;

public interface TaskRepository  extends JpaRepository<Task, Long>{
    // metodo para buscar por titulo
    //Task findByTitle(String title);
    Optional<Task> findByTitle(String title);

}
