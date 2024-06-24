package com.ecommerce.spring_boot_testing.repository;

import com.ecommerce.spring_boot_testing.model.Employee;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.ecommerce.spring_boot_testing.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    /*

    Junit test for save Employee operation
     */

    @DisplayName("Junit test for save Employee Operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

//        Given - pre-condition or setup
        Employee employee = Employee.builder().firstName("Magan").lastName("lala").email("magan@email.com").build();

//        When - action or behavior that we are going test
        Employee savedEmployee = employeeRepository.save(employee);

//        then - verify the output
        Assertions.assertThat(savedEmployee).isNotNull();
        Assertions.assertThat(savedEmployee.getId()).isGreaterThan(0);


    }



}
