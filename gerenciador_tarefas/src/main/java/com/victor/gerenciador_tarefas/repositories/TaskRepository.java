package com.victor.gerenciador_tarefas.repositories;

import com.victor.gerenciador_tarefas.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
