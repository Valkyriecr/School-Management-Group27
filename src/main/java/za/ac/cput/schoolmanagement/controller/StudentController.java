package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.repository.IStudentRepository;


import java.util.List;

@RestController
@RequestMapping("SchoolManagementGroup27/student/")
@Slf4j
public class StudentController {

    @Autowired
    private IStudentRepository repository;

    @GetMapping
    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return repository.save(student);
    }
    @GetMapping("studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId){
        Student student = repository.findByStudentId(studentId);
              //  .orElseThrow(())->ResourceNotFoundException("Student does not exist with the id: "+ studentId);
        return ResponseEntity.ok(student);
    }

}