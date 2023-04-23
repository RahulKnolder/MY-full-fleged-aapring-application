    package com.knoldus.Myspring_projectfullFleged.Entity;

    import com.knoldus.Myspring_projectfullFleged.Service.Address;
    import jakarta.persistence.*;
    import jakarta.transaction.Transactional;
    import lombok.*;

    import java.util.Set;

    @AllArgsConstructor
    @RequiredArgsConstructor
    @ToString
    @Setter
    @Getter
    @Transactional
    @Entity
    public class Employee {
        @Id
        Integer employeeID;
        String name;
        String gender;
        Integer phone;
        String department;
        @Embedded
        Address address;



        @ManyToOne(
                targetEntity = Company.class,
                cascade = CascadeType.ALL
        )
        @JoinColumn(name = "company_id",referencedColumnName = "companyId")
        private Company company;

        @OneToMany(targetEntity = Task.class,cascade = CascadeType.ALL)
        @JoinColumn(name ="cp_fk",referencedColumnName = "employeeID")
        private Set<Task> tasks;


    }
