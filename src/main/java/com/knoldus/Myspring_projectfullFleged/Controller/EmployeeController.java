package com.knoldus.Myspring_projectfullFleged.Controller;


import com.knoldus.Myspring_projectfullFleged.Entity.Employee;
import com.knoldus.Myspring_projectfullFleged.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Add a new employee to the database
    @PostMapping("add")
    public Employee add_data(@RequestBody Employee employee) {
        return service.saveData(employee);
    }

    // Retrieve all employees from the database
    @GetMapping("getall")
    public List get_data() {
        return service.getAllData();
    }

    // Update an existing employee by ID
    @PutMapping("updateByid/{id}")
    public ResponseEntity<Void> putdata(@RequestBody Employee updatedEmployee, @PathVariable Integer id) {
        service.updateById(id, updatedEmployee);
        HttpHeaders headers = new HttpHeaders();
        headers.add("MyCustomHeader", "whole list updated");
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // Update an existing employee's name by ID
    @PatchMapping("updateBYname/{id}")
    public ResponseEntity<Void> updateByname(@RequestBody String name, @PathVariable Integer id) {
        service.upateNameBYID(id, name);
        HttpHeaders headers = new HttpHeaders();
        headers.add("MyCustomHeader", "name updated");
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    // Delete an employee from the database by ID
    @DeleteMapping("deteleBYid/{id}")
    public ResponseEntity<Void> deletebyid(@PathVariable Integer id) {
        service.deletebyid(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("MyCustomHeader", "HeaderValue");
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
