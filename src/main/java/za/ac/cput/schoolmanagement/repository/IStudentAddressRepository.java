/*
Erin Rowan
215271157
StudentAddressRepository.java
 */
package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

import java.util.List;

@Repository
public interface IStudentAddressRepository extends JpaRepository<StudentAddress, StudentAddress.StudentAddressId> {
    List<StudentAddress> findAll();
    List<StudentAddress>findByStudentId(String studentId);
}
