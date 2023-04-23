package com.knoldus.Myspring_projectfullFleged.Reposatory;

import com.knoldus.Myspring_projectfullFleged.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskReposatory extends JpaRepository<Task,Integer> {
}
