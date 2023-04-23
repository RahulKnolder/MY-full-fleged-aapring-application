package com.knoldus.Myspring_projectfullFleged;

import com.knoldus.Myspring_projectfullFleged.Entity.Company;
import com.knoldus.Myspring_projectfullFleged.Reposatory.EmployeeRepository;
import com.knoldus.Myspring_projectfullFleged.Service.Address;
import com.knoldus.Myspring_projectfullFleged.Entity.Employee;
import com.knoldus.Myspring_projectfullFleged.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class MySpringProjectFullFlegedApplicationTests {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    Employee employee;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        employee = new Employee(3,
                "rahul",
                "femael",
                1234,
                "javaStudio",
                new Address("city",
                        "jharkhand",
                        23),
                new Company(),
                new HashSet<>());
    }

    @Test
    void testSaveData() {
        when(employeeRepository.save(employee))
                .thenReturn(employee);
        Employee savedEntity = employeeService.saveData(employee);
        assertEquals("it is equal", employee, savedEntity);
    }

    @Test
    void testGetAllData() {
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(new Employee(3,
                "rahul",
                "femael",
                1234,
                "javaStudio",
                new Address("city",
                        "jharkhand",
                        23),
                new Company(),
                new HashSet<>()));

        employees.add(new Employee(4,
                "rahul",
                "femael",
                1234,
                "javaStudio",
                new Address("sahibjabg",
                        "Sinha",
                        23),
                new Company(),
                new HashSet<>()));
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> savedEntity = employeeService.getAllData();
        assertEquals("it is equal", employees, savedEntity);
    }

    @Test
    void shouldUpdateEmployeeById() {
        // Create an Employee object to update
        Employee toBeUpdated = new Employee(
                3, "rahul",
                "femael", 1234,
                "javaStudio",
                new Address("city",
                        "jharkhand",
                        23),
                new Company(),
                new HashSet<>());
        // Create an updated Employee object
        Employee updated = new Employee(3,
                "jitin",
                ",male",
                1234,
                "javaStudio",
                new Address("city",
                        "jharkhand",
                        23), new Company(),
                new HashSet<>());

        // Mock the repository's findById method
        when(employeeRepository.findById(anyInt()))
                .thenReturn(Optional.of(toBeUpdated));

        // Call the service's updateById method
        ResponseEntity<Employee> responseEntity = employeeService.updateById(1, updated);

        // Verify that the repository's save method is called with the correct argument
        verify(employeeRepository).save(toBeUpdated);

        // Assert that the response status code is OK
        assertEquals("Response status code should be OK", HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldUpateNameBYID() {

        // Create an Employee object to update
        Employee toBeUpdated = new Employee(3,
                "rahul",
                "femael",
                1234,
                "javaStudio",
                new Address("city",
                        "jharkhand", 23),
                new Company(),
                new HashSet<>());
        // Name Employee
        String name;
        // Mock the repository's findById method
        when(employeeRepository.findById(anyInt())).thenReturn(Optional.of(toBeUpdated));
        // Call the service's updateById method
        ResponseEntity<Employee> responseEntity = employeeService.upateNameBYID(1, anyString());
        // Verify that the repository's save method is called with the correct argument
        verify(employeeRepository).save(toBeUpdated);
        // Assert that the response status code is OK
        assertEquals("Response status code should be OK", HttpStatus.OK, responseEntity.getStatusCode());

    }


    @Test
    void shoulDeletebyID() {
        // Create a new Employee object to be deleted
        Employee toBeDeleted = new Employee(3,
                "rahul",
                "femael",
                1234,
                "javaStudio",
                new Address("city",
                        "jharkhand",
                        23),
                new Company(),
                new HashSet<>());

        // When the findById method of employeeRepository is called with any integer value,
        // return an Optional containing the toBeDeleted Employee object
        when(employeeRepository.findById(anyInt()))
                .thenReturn(Optional.of(toBeDeleted));

        // Call the deletebyid method of employeeService with the integer value 1,
        // which should delete the Employee with id 1 from the database
        ResponseEntity<Employee> employeeResponseEntity = employeeService.deletebyid(1);

        // Verify that the deleteById method of employeeRepository was called with the integer value 1
        verify(employeeRepository).deleteById(1);

        // Assert that the status code of the ResponseEntity object returned by the deletebyid method
        // of employeeService is HttpStatus.OK
        assertEquals("Response status code should be OK", HttpStatus.OK, employeeResponseEntity.getStatusCode());

    }
}
