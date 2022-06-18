package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.factory.NameFactory;
import za.ac.cput.schoolmanagement.factory.StudentFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    private Student student;
    private Name name;
    private String baseURL;

    @BeforeEach
    void setUp(){
       this.name = NameFactory.build("Erin","Chad","Rowan");
       this.student = StudentFactory.build("1234","erowan95@gmail.com", name);
       this.baseURL="http://localhost:"+this.port+"/SchoolManagementGroup27/student/";
    }

    @Test
    @Order(1)
    void save(){
        String url=baseURL+"save";
        System.out.println(url);
        ResponseEntity<Student> response=this.restTemplate.postForEntity(url,this.student,Student.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read(){
        String url=baseURL + "read/"+this.student.getStudentId();
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.getForEntity(url,Student.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(3)
    void findAllFilled(){
        String url=baseURL+"all";
        System.out.println(url);
        ResponseEntity<Student[]> response=this.restTemplate.getForEntity(url,Student[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertTrue(response.getBody().length==1)
        );
    }

    @Test
    @Order(4)
    void delete(){
        String url=baseURL + "delete/"+this.student.getStudentId();
        this.restTemplate.delete(url);
        //validates delete was successful
        url=baseURL+"all";
        System.out.println(url);
        ResponseEntity<Student[]> response=this.restTemplate.getForEntity(url,Student[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertTrue(response.getBody().length==0)
        );
    }

}