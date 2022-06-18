package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.*;
import za.ac.cput.schoolmanagement.factory.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    private StudentAddress studentAddress;
    private String baseURL;
    private Country country;
    private City city;
    private Address address;

    @BeforeEach
    void setUp(){
        country = CountryFactory.build("ZA","South Africa");
        city = CityFactory.build("CPT","Cape Town",country);
        address = AddressFactory.build("19","house","19","Yellowwood",7800,city);
        studentAddress= StudentAddressFactory.build("1234",address);
        this.baseURL="http://localhost:"+this.port+"/SchoolManagementGroup27/student-address/";
    }

    @Test
    @Order(1)
    void save(){
        String url=baseURL+"save";
        System.out.println(url);
        ResponseEntity<StudentAddress> response=this.restTemplate.postForEntity(url,this.studentAddress,StudentAddress.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertNotNull(response.getBody())
        );
    }

    @Test
    @Order(2)
    void read(){
        String url=baseURL + "read/"+this.studentAddress.getStudentId();
        System.out.println(url);
        ResponseEntity<StudentAddress> response = this.restTemplate.getForEntity(url,StudentAddress.class);
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
        ResponseEntity<StudentAddress[]> response=this.restTemplate.getForEntity(url,StudentAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertTrue(response.getBody().length==1)
        );
    }

    @Test
    @Order(4)
    void delete(){
        String url=baseURL + "delete/"+this.studentAddress.getStudentId();
        this.restTemplate.delete(url);
        //validates delete was successful
        url=baseURL+"all";
        System.out.println(url);
        ResponseEntity<StudentAddress[]> response=this.restTemplate.getForEntity(url,StudentAddress[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertTrue(response.getBody().length==0)
        );
    }

}