package com.knoldus.Myspring_projectfullFleged.Service;

import com.knoldus.Myspring_projectfullFleged.Entity.Employee;
import com.knoldus.Myspring_projectfullFleged.Reposatory.EmployeeRepository;
import com.knoldus.Myspring_projectfullFleged.Reposatory.TaskReposatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TaskReposatory taskReposatory;

    public Employee saveData(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllData() {
        return employeeRepository.findAll();
    }

    public ResponseEntity<Employee> updateById(Integer targetId, Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(targetId);
         if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setName(updatedEmployee.getName());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setPhone(updatedEmployee.getPhone());
            employee.setGender(updatedEmployee.getGender());
            employeeRepository.save(employee);
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Employee> upateNameBYID(Integer targetId,String name) {
        Optional<Employee> employeeOptional = employeeRepository.findById(targetId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setName(name);
            employeeRepository.save(employee);
        }
        return ResponseEntity.ok().build();
    }


    public ResponseEntity<Employee> deletebyid(Integer targetId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(targetId);
        if (employeeOptional.isPresent()) {
            employeeRepository.deleteById(targetId);
        }
        return ResponseEntity.ok().build();
    }
}

