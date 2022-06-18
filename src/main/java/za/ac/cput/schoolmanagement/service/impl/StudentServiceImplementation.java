/*
Erin Rowan
215271157
StudentServiceImplementation.java
 */
package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.repository.IStudentRepository;
import za.ac.cput.schoolmanagement.service.service.IStudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements IStudentService {
    public final IStudentRepository repository;
    @Autowired
    public StudentServiceImplementation(IStudentRepository repository){this.repository=repository;}

    @Override
    public Student save(Student student){return this.repository.save(student);}

    @Override
    public Optional<Student> read(Student.StudentId studentId){return this.repository.findById(studentId);}

    @Override
    public void delete(Student student){this.repository.delete(student);}

    @Override
    public Student findByStudentId(String studentId){
        return this.repository.findByStudentId(studentId);
    }

    @Override
    public List<Student> findAll(){return this.repository.findAll();}
}
