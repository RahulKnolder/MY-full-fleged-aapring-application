package com.knoldus.Myspring_projectfullFleged.Reposatory;

import com.knoldus.Myspring_projectfullFleged.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyReposatory extends JpaRepository<Company,Integer> {
}
