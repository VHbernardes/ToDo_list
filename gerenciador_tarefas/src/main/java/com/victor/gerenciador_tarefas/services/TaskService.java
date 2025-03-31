//package com.victor.gerenciador_tarefas.services;
//
//import com.victor.gerenciador_tarefas.models.Task;
//import com.victor.gerenciador_tarefas.repositories.TaskRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TaskService {
//
//    private final TaskRepository taskRepository;
//
//    @Autowired
//    public TaskService(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }
//
//    // Criar ou atualizar tarefa
//    public Task saveTask(Task task) {
//        return taskRepository.save(task);
//    }
//
//    // Listar todas as tarefas
//    public List<Task> getAllTasks() {
//        return taskRepository.findAll();
//    }
//
//    // Buscar tarefa por ID
//    public Optional<Task> getTaskById(Long id) {
//        return taskRepository.findById(id);
//    }
//
//    // Deletar tarefa por ID
//    public void deleteTask(Long id) {
//        taskRepository.deleteById(id);
//    }
//}

package com.victor.gerenciador_tarefas.services;

import com.victor.gerenciador_tarefas.models.Task;
import com.victor.gerenciador_tarefas.models.TaskStatus;
import com.victor.gerenciador_tarefas.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void updateTaskStatus(Long id, TaskStatus status) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            task.get().setStatus(status);
            taskRepository.save(task.get());
        }
    }
}

