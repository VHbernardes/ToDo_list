package com.victor.gerenciador_tarefas.controllers;

import com.victor.gerenciador_tarefas.models.Task;
import com.victor.gerenciador_tarefas.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Página inicial com todas as tarefas
    @GetMapping
    public String getAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "index"; // Retorna o template Thymeleaf "index.html"
    }

    // Exibir formulário para criar nova tarefa
    @GetMapping("/new")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form"; // Retorna o template Thymeleaf "task-form.html"
    }

    // Criar ou editar tarefa
    @PostMapping("/save")
    public String saveTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks"; // Redireciona para a página de tarefas
    }

    // Deletar tarefa
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks"; // Redireciona para a página de tarefas
    }
}
