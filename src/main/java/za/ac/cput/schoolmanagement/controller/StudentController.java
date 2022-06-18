package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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

    @PostMapping("save")
    public Student createStudent(@RequestBody Student student){
        return repository.save(student);
    }

   @GetMapping("read/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable String studentId){
        Student student = repository.findByStudentId(studentId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("delete/{studentId}")
    public ResponseEntity<Void>delete(@PathVariable Student studentId){
        log.info("Delete Request:{}",studentId);
        this.repository.delete(studentId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Student>>findAll() {
        List<Student> studentList=this.repository.findAll();
        return ResponseEntity.ok(studentList);
    }
}