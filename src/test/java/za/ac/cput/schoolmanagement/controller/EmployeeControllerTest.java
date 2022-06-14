package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.factory.EmployeeFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeControllerTest {
    @LocalServerPort
    public int port;
    @Autowired public EmployeeController controller;
    @Autowired public TestRestTemplate restTemplate;
    public Employee employee;
    public String baseUrl;
    @BeforeEach
    void setUp()
    {
        this.employee= EmployeeFactory.build("test-id-2","dpengmarais99@gmail.com");
        this.baseUrl="http://localhost:"+this.port+"/SchoolManagementGroup27/employee/";

    }
    @Test
    @Order(1)
    void save(){
        String url=baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Employee> response= this.restTemplate.postForEntity(url,this.employee,Employee.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(2)
    void read(){
        String url=baseUrl + "read/" + this.employee.getStaffid();
        System.out.println(url);
        ResponseEntity<Employee>response=this.restTemplate.getForEntity(url,Employee.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertNotNull(response.getBody())
        );

    }
    @Test
    @Order(3)
    void delete(){
        String url=baseUrl+"delete/"+ this.employee.getStaffid();
        this.restTemplate.delete(url);
    }
    @Test
    @Order(4)
    void findAll(){
        String url=baseUrl+"all";
        System.out.println(url);
        ResponseEntity<Employee[]>response= this.restTemplate.getForEntity(url,Employee[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertTrue(response.getBody().length==0)
        );
    }

}