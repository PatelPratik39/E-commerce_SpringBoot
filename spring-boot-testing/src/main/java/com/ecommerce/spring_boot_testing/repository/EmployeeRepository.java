package com.ecommerce.spring_boot_testing.repository;

import com.ecommerce.spring_boot_testing.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository< Employee, Long > {

    Optional<Employee> findByEmail(String email);

}
