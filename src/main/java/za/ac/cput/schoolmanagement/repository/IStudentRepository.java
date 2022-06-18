/*
Erin Rowan
215271157
StudentRepository.java
 */
package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Student;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Student.StudentId> {
    List<Student>findAll();
    Student findByStudentId(String studentId);
}
