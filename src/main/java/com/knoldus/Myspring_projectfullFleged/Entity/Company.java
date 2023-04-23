package com.knoldus.Myspring_projectfullFleged.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.ref.PhantomReference;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Company {

    @Id
    private Integer companyId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "employeeID")
    private Employee employee;

}
