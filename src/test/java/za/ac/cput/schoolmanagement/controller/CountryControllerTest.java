/*CountryControllerTest.java
Test for the CountryControllerTest
Author: Zaakirah Fakier (220461503)
Date: 18 June 2022
 */
package za.ac.cput.schoolmanagement.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.factory.CountryFactory;

import java.util.Arrays;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CountryControllerTest {
    @LocalServerPort
    public int port;
    @Autowired public CountryController controller;
    @Autowired public TestRestTemplate restTemplate;
    public Country country;
    public String baseUrl;
    @BeforeEach
    void setUp()
    {
        this.country= CountryFactory.build("FR","France");
        this.baseUrl="http://localhost:"+this.port+"/SchoolManagementGroup27/country/";

    }

    @Test
    @Order(1)
    void save(){
        String url=baseUrl + "save";
        System.out.println(url);
        ResponseEntity<Country> response= this.restTemplate.postForEntity(url,this.country,Country.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertNotNull(response.getBody())
        );
    /*}
    @Test
    @Order(2)
    void read(){
        String url=baseUrl + "read/" + this.country.getCountryId();
        System.out.println(url);
        ResponseEntity<Country>response=this.restTemplate.getForEntity(url,Country.class);
        System.out.println(response);
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertNotNull(response.getBody())
        );

    }
    @Test
    @Order(3)
    void delete(){
        String url=baseUrl+"delete/"+ this.country.getCountryId();
        this.restTemplate.delete(url);
    }
    @Test
    @Order(4)
    void findAll(){
        String url=baseUrl+"all";
        System.out.println(url);
        ResponseEntity<Country[]>response= this.restTemplate.getForEntity(url,Country[].class);
        System.out.println(Arrays.asList(response.getBody()));
        assertAll(
                ()->assertEquals(HttpStatus.OK,response.getStatusCode()),()->assertTrue(response.getBody().length==0)
        ); */
    }

}