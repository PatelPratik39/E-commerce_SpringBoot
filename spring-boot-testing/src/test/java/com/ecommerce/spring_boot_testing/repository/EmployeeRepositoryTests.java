package com.ecommerce.spring_boot_testing.repository;

import com.ecommerce.spring_boot_testing.model.Employee;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setup(){
        employee = Employee.builder().firstName("Nakuli").lastName("Vadan").email("nakuli@email.com").build();
    }

    /*

    Junit test for save Employee operation
     */

    @DisplayName("Junit test for save Employee Operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee(){

//        Given - pre-condition or setup
//        Employee employee = Employee.builder().firstName("Magan").lastName("lala").email("magan@email.com").build();

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
//        Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
        Employee employee1 = Employee.builder().firstName("Chaman").lastName("zingoor").email("chaman@email.com").build();
        Employee employee2 = Employee.builder().firstName("Lallu Lal").lastName("Singh").email("lallu@email.com").build();
        Employee employee3 = Employee.builder().firstName("Chucha Singh").lastName("Bhatto").email("chucha@email.com").build();
        employeeRepository.save(employee1);
//        employeeRepository.save(employee);
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
//            Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
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
//                Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
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
        public void givenEmployeeObject_whenUpdatedEmployee_thenReturnUpdatedEmployee(){

    //        Given - Pre-condition or setup test
//            Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
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

        //    JUnit test for delete employee
      @DisplayName("JUnit test for remove employee from database")
      @Test
      public void givenEmployeeObject_whenDelete_thenRemoveEmployee(){
        //        Given - Pre-condition or setup test
//          Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
          employeeRepository.save(employee);

        //        When - action or the behavior that we are going to test
          employeeRepository.deleteById(employee.getId());
          Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

        //        then - verify the output
          assertThat(employeeOptional).isEmpty();
     }


     //    JUnit test for Custom Query using JPQL
         @DisplayName("JUnit test for JPQL Query")
         @Test
         public void givenFirstNameAndLastName_whenFindByJPQL_thenReturnObject(){

     //        Given - Pre-condition or setup test
//             Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
             employeeRepository.save(employee);
             String firstName = "Mangoo";
             String lastName = "Moti";

     //        When - action or the behavior that we are going to test
             Employee savedEmployee = employeeRepository.findByJPQL(firstName, lastName);

     //        then - verify the output
             assertThat(savedEmployee).isNotNull();

         }


    //    JUnit test for Custom Query using JPQL
    @DisplayName("JUnit test for JPQL Query with Named Params")
    @Test
    public void givenFirstNameAndLastName_whenFindByJPQLNamedParams_thenReturnObject(){

        //        Given - Pre-condition or setup test
//        Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
        employeeRepository.save(employee);
        String firstName = "Mangoo";
        String lastName = "Moti";

        //        When - action or the behavior that we are going to test
        Employee savedEmployee = employeeRepository.findByJPQLNamedParams(firstName, lastName);

        //        then - verify the output
        assertThat(savedEmployee).isNotNull();

    }


    //    JUnit test for Custom Query using Native Query
    @DisplayName("JUnit test for JPQL Query with Native Query")
    @Test
    public void givenFirstNameAndLastName_whenFindByNativeSQL_thenReturnObject(){

        //        Given - Pre-condition or setup test
//        Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
        employeeRepository.save(employee);

        //        When - action or the behavior that we are going to test
        Employee foundEmployee = employeeRepository.findByNativeSQL(employee.getFirstName(), employee.getLastName());

        //        then - verify the output
        assertThat(foundEmployee).isNotNull();

    }


    //    JUnit test for Custom Query using Native Query Named
    @DisplayName("JUnit test for JPQL Query with Native Query with Named Params")
    @Test
    public void givenFirstNameAndLastName_whenFindByNativeSQLNamedParams_thenReturnObject(){

        //        Given - Pre-condition or setup test
        Employee employee = Employee.builder().firstName("Mangoo").lastName("Moti").email("mangoo@email.com").build();
        employeeRepository.save(employee);

        //        When - action or the behavior that we are going to test
        Employee foundEmployee = employeeRepository.findByNativeSQLNamed(employee.getFirstName(), employee.getLastName());

        //        then - verify the output
        assertThat(foundEmployee).isNotNull();

    }

}
