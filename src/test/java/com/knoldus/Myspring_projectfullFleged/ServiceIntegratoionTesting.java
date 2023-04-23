package com.knoldus.Myspring_projectfullFleged;
import com.knoldus.Myspring_projectfullFleged.Entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MySpringProjectFullFlegedApplication.class)
 class ServiceIT {


    @LocalServerPort
    private Integer port;


    // Creates a new instance of TestRestTemplate with HttpClientOption.ENABLE_REDIRECTS option enabled.
    private final TestRestTemplate restTemplate = new TestRestTemplate(TestRestTemplate.HttpClientOption.ENABLE_REDIRECTS);


//    @Test
//    void testAddEndpoint() {
//        Employee employee = new Employee(22, "Rahul", "Female", 1234, "JavaStudio", new Address("City", "Jharkhand", 23),new HashSet<>());
//        String endpoint = "http://localhost:" + port + "/employees/add";
//        ResponseEntity<Employee> response = restTemplate.postForEntity(endpoint, employee, Employee.class);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }



    @Test
    void testGetAllEndpoint() {
        String endpoint = "http://localhost:" + port + "/employees/getall";
        ResponseEntity<List> response = restTemplate.getForEntity(endpoint,List.class);
        List<Employee> employees= response.getBody();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


    @Test
    void testUpdateByIdEndPoint() {
        String endpoint = "http://localhost:" + port + "/employees/updateByid/22";
        restTemplate.put(endpoint,Employee.class);
        ResponseEntity<Employee> response = restTemplate.getForEntity(endpoint,Employee.class);
        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());
    }




}
