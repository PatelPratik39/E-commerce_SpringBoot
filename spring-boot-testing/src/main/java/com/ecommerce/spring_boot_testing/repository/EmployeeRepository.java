package com.ecommerce.spring_boot_testing.repository;

import com.ecommerce.spring_boot_testing.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository< Employee, Long > {

    Optional<Employee> findByEmail(String email);


//    define a custom query using JPQL with index params
    @Query("SELECT e from Employee e WHERE e.firstName = ?1 and e.lastName = ?2")
    Employee findByJPQL(String firstName, String lastName);

    //    define a custom query using JPQL with index params
    @Query("SELECT e from Employee e WHERE e.firstName = :firstName and e.lastName = :lastName")
    Employee findByJPQLNamedParams( @Param("firstName") String firstName, @Param("lastName") String lastName);


}
