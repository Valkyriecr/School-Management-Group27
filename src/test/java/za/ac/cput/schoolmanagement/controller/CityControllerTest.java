/* CityControllerTest.java
   Tests for the CityController
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 17 June 2022
 */
package za.ac.cput.schoolmanagement.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.factory.CityFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class CityControllerTest {

    @LocalServerPort
    public int port;
    @Autowired
    public CityController controller;
    @Autowired
    public TestRestTemplate restTemplate;
    public City city;
    public String baseUrl;

    @BeforeEach
    void setUp(){
        this.city = CityFactory.createCity("#dum123","Paris");
        this.baseUrl = "http://localhost:" +this.port+"/SchoolManagementGroup27/city/";
    }

    @Test
    void a_save() {
        String url = baseUrl + "save";
        System.out.println(url);
        ResponseEntity<City> response = this.restTemplate.postForEntity(url,this.city,City.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK,response.getStatusCode()),
                ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    void b_delete() {
        String url = baseUrl + "delete/"+ this.city.getId();
        this.restTemplate.delete(url);
    }

}