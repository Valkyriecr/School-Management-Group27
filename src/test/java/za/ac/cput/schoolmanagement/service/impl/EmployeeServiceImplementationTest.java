//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.factory.EmployeeFactory;
import za.ac.cput.schoolmanagement.service.service.EmployeeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeServiceImplementationTest {
    public final Employee employee= EmployeeFactory.build("test-for-staffId","dpengmarais99@gmail.com");
    public Employee.EmployeeId employeeId= EmployeeFactory.buildId(this.employee);
    @Autowired
    public EmployeeService service;

    @Test
    @Order(1)
    void save(){
        Employee isSaved=this.service.save(this.employee);
        assertAll(
                ()->assertNotNull(isSaved),
                ()->assertEquals(this.employee,isSaved)
        );
    }
@Test
    @Order(4)
    void teardown(){this.service.delete(this.employee);}
    @Test
    @Order(2)
    void read(){
        Optional<Employee> read=this.service.read(this.employeeId);
        System.out.println(read);
        assertAll(
                ()->assertTrue(read.isPresent()),()->assertEquals(this.employee,read.get())
        );
    }
    @Test
    @Order(5)
    void findAll(){
        List<Employee> employeeList=this.service.findAll();
        assertEquals(0,employeeList.size());
    }
    @Test
    @Order(3)
    void findByStaffId(){
        String staffId=this.employeeId.getStaffId();
        List<Employee>employeeList=this.service.findByStaffId(staffId);
        System.out.println(employeeList);
        assertSame(1,employeeList.size());
    }
}