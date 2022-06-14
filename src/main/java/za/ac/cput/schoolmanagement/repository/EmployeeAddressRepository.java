//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import java.util.List;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress,EmployeeAddress.EmployeeAddressId> {
    List<EmployeeAddress> findAll();
    List<EmployeeAddress>findByStaffId(String staffId);

}
