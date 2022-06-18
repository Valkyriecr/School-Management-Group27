/*
Erin Rowan
215271157
StudentService.java
 */
package za.ac.cput.schoolmanagement.service.service;

import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface IStudentService extends IService<Student,Student.StudentId> {
    List<Student>findAll();
    Student findByStudentId(String studentId);
}
