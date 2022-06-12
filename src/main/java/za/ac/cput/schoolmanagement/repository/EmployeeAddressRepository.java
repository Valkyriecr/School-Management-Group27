package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import java.util.List;

@Repository
public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress,String> {
    List<EmployeeAddress> findAll();
    void deleteById(String id);
    List<EmployeeAddress>findByStaffId(String staffId);

}
