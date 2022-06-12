package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
    List<Employee> findByEmployeeNumber(String employeeNumber);
}
