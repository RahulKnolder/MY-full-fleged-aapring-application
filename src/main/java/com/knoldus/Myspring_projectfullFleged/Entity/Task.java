package com.knoldus.Myspring_projectfullFleged.Entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Task {

    @Id
    Integer taskID;
    String description;

    @OneToMany
    @JoinColumn(name = "enployeID")
    Set<Employee> employees;
}
