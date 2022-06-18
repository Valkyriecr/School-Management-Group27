//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.service.service.EmployeeService;
@Component
public class EmployeeApi {
    private final EmployeeService employeeService;
    @Autowired public EmployeeApi(EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    public Employee save(Employee employee){
        return this.employeeService.save(employee);
    }

}
