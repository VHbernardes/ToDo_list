//package com.victor.gerenciador_tarefas.repositories;
//
//import com.victor.gerenciador_tarefas.models.Task;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface TaskRepository extends JpaRepository<Task, Long> {
//}

package com.victor.gerenciador_tarefas.repositories;

import com.victor.gerenciador_tarefas.models.Task;
import com.victor.gerenciador_tarefas.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}

