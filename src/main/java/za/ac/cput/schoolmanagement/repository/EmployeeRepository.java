//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Employee.EmployeeId> {
    List<Employee> findAll();
    List<Employee> findByStaffId(String staffId);
}
