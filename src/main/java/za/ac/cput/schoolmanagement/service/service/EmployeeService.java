//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.service.service;

import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;


public interface EmployeeService extends IService<Employee, Employee.EmployeeId> {
    List<Employee> findAll();
    //void deleteById(String staffId);
    List<Employee>findByStaffId(String staffId);
}
