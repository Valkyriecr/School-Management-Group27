package za.ac.cput.schoolmanagement.service.service;

import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends IService<Employee,String> {
    Optional<Employee> read(String staffId);

    List<Employee> findAll();
}
