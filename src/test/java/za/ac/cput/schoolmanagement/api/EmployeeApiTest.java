package za.ac.cput.schoolmanagement.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.factory.EmployeeFactory;
import za.ac.cput.schoolmanagement.service.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeApiTest {
    @Autowired
    private EmployeeService employeeService;
    @Autowired private EmployeeApi employeeApi;

    private Employee employee= EmployeeFactory.build("1002","dpengmarais99@gmail.com");
@Test
    void save(){
    Employee save=this.employeeApi.save(this.employee);
    }
}