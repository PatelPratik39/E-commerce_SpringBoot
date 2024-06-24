package com.ecommerce.spring_boot_testing.repository;

import com.ecommerce.spring_boot_testing.model.Employee;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.ecommerce.spring_boot_testing.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    /*

    Junit test for save Employee operation
     */

//    @DisplayName("Junit test for save Employee Operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

//        Given - pre-condition or setup
        Employee employee = Employee.builder().firstName("Magan").lastName("lala").email("magan@email.com").build();

//        When - action or behavior that we are going test
        Employee savedEmployee = employeeRepository.save(employee);

//        then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }
//    JUnit test for
    @DisplayName("Create Employee and getAll from repository")
    @Test
    public void givenEmployeeList_whenFindAll_thenEmployeeList(){

//        Given - Pre-condition or setup test
        Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
        Employee employee1 = Employee.builder().firstName("Chaman").lastName("zingoor").email("chaman@email.com").build();
        Employee employee2 = Employee.builder().firstName("Lallu Lal").lastName("Singh").email("lallu@email.com").build();
        Employee employee3 = Employee.builder().firstName("Chucha Singh").lastName("Bhatto").email("chucha@email.com").build();
        employeeRepository.save(employee1);
        employeeRepository.save(employee);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);

//        When - action or the behavior that we are going to test
        List <Employee> employeeList = employeeRepository.findAll();

//        then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(3);

    }

    //    JUnit test for
        @DisplayName(" Junit test for get employee id operation")
        @Test
        public void givenEmployeeObject_whenFindById_thenReturnEmployeeObject(){

    //        Given - Pre-condition or setup test
            Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
            employeeRepository.save(employee);

    //        When - action or the behavior that we are going to test
            Employee employeeDB = employeeRepository.findById(employee.getId()).get();

    //        then - verify the output
            assertThat(employeeDB).isNotNull();

        }

        //    JUnit test for
            @DisplayName("JUnite test for get employee by Email operation")
            @Test
            public void givenEmployeeEmail_whenFindByEMail_thenEmployeeObject(){

        //        Given - Pre-condition or setup test
                Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
                employeeRepository.save(employee);

        //        When - action or the behavior that we are going to test
                Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();

        //        then - verify the output
                assertThat(employeeDB).isNotNull();

            }
//    Update Employee Junit test case
    //    JUnit test for
        @DisplayName("Update Employee Junit test case")
        @Test
        public void givenemployeeObject_whenUpdatedEmployee_thenReturnUpdatedEmployee(){

    //        Given - Pre-condition or setup test
            Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
            employeeRepository.save(employee);

    //        When - action or the behavior that we are going to test
            Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
            savedEmployee.setEmail("mangooMoti@email.com");
            savedEmployee.setFirstName("Mangoo Gondi");
            Employee updatedEmployee =  employeeRepository.save(savedEmployee);
    //        then - verify the output
            assertThat(updatedEmployee).isNotNull();
            assertThat(updatedEmployee.getEmail()).isEqualTo("mangooMoti@email.com");
            assertThat(updatedEmployee.getFirstName()).isEqualTo("Mangoo Gondi");

        }

}
