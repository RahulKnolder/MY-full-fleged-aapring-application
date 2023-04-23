package com.knoldus.Myspring_projectfullFleged.Reposatory;

import com.knoldus.Myspring_projectfullFleged.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
