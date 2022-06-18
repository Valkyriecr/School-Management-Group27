package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.factory.EmployeeAddressFactory;
import za.ac.cput.schoolmanagement.service.service.EmployeeAddressService;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressControllerTest {
    @LocalServerPort
    private int port;
    @Autowired private EmployeeAddressController controller;
    @Autowired private TestRestTemplate restTemplate;
    private EmployeeAddress employeeAddress;
    private String baseUrl;
    @BeforeEach
    void setUp(){
        this.employeeAddress=EmployeeAddressFactory.build("1002");
        this.baseUrl="http://localhost:" + this.port+ "/SchoolManagementGroup27/employee-address/";

    }
    @Test
    @Order(1)
    void save(){
        String url=baseUrl + "save";
        System.out.println(url);
        ResponseEntity<EmployeeAddress> response=this.restTemplate.postForEntity(url,this.employeeAddress,EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(2)
    void read(){
        String url=baseUrl + "read/" + this.employeeAddress.getStaffId();
        System.out.println(url);
        ResponseEntity<EmployeeAddress>response=this.restTemplate.getForEntity(url,EmployeeAddress.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()->assertNotNull(response.getBody())
        );
    }
    @Test
    @Order(4)
    void delete(){
        String url=baseUrl+"delete/" +this.employeeAddress.getStaffId();
        this.restTemplate.delete(url,controller.delete(employeeAddress));
    }
    @Test
    @Order(3)
    void findAll(){
        String url=baseUrl+ "all";
        System.out.println(url);
        ResponseEntity<EmployeeAddress[]> response=this.restTemplate.getForEntity(url,EmployeeAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertTrue(response.getBody().length==2)
        );
    }

}

