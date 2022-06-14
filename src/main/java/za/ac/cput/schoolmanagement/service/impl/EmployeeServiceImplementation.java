//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.repository.EmployeeRepository;
import za.ac.cput.schoolmanagement.service.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    public final EmployeeRepository repository;
    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository repository) {
        this.repository = repository;
    }


    @Override
    public Employee save(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Optional<Employee> read(Employee.EmployeeId employeeId) {
        return this.repository.findById(employeeId);
    }
@Override
public void delete(Employee employee){
        this.repository.delete(employee);
}
    @Override
    public List findByStaffId(String staffId) {
        return this.repository.findByStaffId(staffId);}

   @Override
    public List<Employee> findAll(){
        return this.repository.findAll();
   }
}

