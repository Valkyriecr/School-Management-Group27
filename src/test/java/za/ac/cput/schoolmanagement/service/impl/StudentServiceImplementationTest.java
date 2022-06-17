/*
Erin Rowan
215271157
StudentServiceImplementationTest.java
 */
package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.factory.StudentFactory;
import za.ac.cput.schoolmanagement.service.service.StudentService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentServiceImplementationTest {
    public final Student student = StudentFactory.build("Erin","erowan95@gmail.com");
    public Student.StudentId studentId= StudentFactory.buildId(this.student);
    @Autowired
    public StudentService service;

    @Test
    @Order(1)
    void save(){
        Student std=this.service.save(this.student);
        assertAll(()->assertNotNull(std),()->assertEquals(this.student,std));
    }
    @Test
    @Order(2)
    void read(){
        Optional<Student> read=this.service.read(this.studentId);
        System.out.println(read);
        assertAll(()->assertTrue(read.isPresent()),()->assertEquals(this.student,read.get()));
    }
    @Test
    @Order(3)
    void findByStudentId(){
        String studentId=this.studentId.getStudentId();
        List<Student>studentList=this.service.findByStudentId(studentId);
        System.out.println(studentList);
        assertSame(1,studentList.size());
    }
    @Test
    @Order(4)
    void delete(){this.service.delete(this.student);}

    @Test
    @Order(5)
    void findAll(){
        List<Student>   studentList=this.service.findAll();
        assertEquals(0,studentList.size());
    }
}