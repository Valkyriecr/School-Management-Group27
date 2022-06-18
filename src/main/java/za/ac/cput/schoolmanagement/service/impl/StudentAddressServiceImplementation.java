/*
Erin Rowan
215271157
StudentAddressServiceImplementation.java
 */
package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.repository.IStudentAddressRepository;
import za.ac.cput.schoolmanagement.service.service.IStudentAddressService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAddressServiceImplementation implements IStudentAddressService {
    private final IStudentAddressRepository repository;

    @Autowired
    public StudentAddressServiceImplementation(IStudentAddressRepository repository){
        this.repository=repository;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress){
        return this.repository.save(studentAddress);
    }
    @Override
    public Optional<StudentAddress> read(StudentAddress.StudentAddressId studentAddressId){
        return this.repository.findById(studentAddressId);
    }
    @Override
    public void delete(StudentAddress studentAddress){
        this.repository.delete(studentAddress);
    }
    @Override
    public List<StudentAddress> findAll(){
        return this.repository.findAll();
    }
    @Override
    public List findByStudentId(String studentId){
        return this.repository.findByStudentId(studentId);
    }
}
