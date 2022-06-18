/*
Erin Rowan
215271157
StudentAddressServiceImplementationTest.java
 */
package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.factory.AddressFactory;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.factory.CountryFactory;
import za.ac.cput.schoolmanagement.factory.StudentAddressFactory;
import za.ac.cput.schoolmanagement.service.service.IStudentAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentAddressServiceImplementationTest {
    public final Country country = CountryFactory.build("ZA","South Africa");
    public final City city = CityFactory.build("CPT","Cape Town",country);
    public final Address address = AddressFactory.build("19","house","19","Yellowwood",7800,city);
    public final StudentAddress studentAddress= StudentAddressFactory.build("1234",address);
    public StudentAddress.StudentAddressId studentAddressId=StudentAddressFactory.buildId(this.studentAddress);
    @Autowired
    public IStudentAddressService service;
    @Test
    @Order(1)
    void save(){
        StudentAddress address = this.service.save(this.studentAddress);
        assertAll(()->assertNotNull(address),()->assertEquals(this.studentAddress,address));
    }
    @Test
    @Order(2)
    void read(){
        Optional<StudentAddress> read=this.service.read(this.studentAddressId);
        System.out.println(read);
        assertAll(()->assertTrue(read.isPresent()),()->assertEquals(this.studentAddress,read.get()));
    }
    @Test
    @Order(3)
    void findByStudentId(){
        String studentId=this.studentAddressId.getStudentId();
        List<StudentAddress> studentAddressList=this.service.findByStudentId(studentId);
        System.out.println(studentAddressList);
        assertSame(1,studentAddressList.size());
    }
    @Test
    @Order(4)
    void findAll(){
        List<StudentAddress>studentAddressList=this.service.findAll();
        assertEquals(1,studentAddressList.size());
        System.out.println(studentAddressList);
    }
    @Test
    @Order(5)
    void delete(){this.service.delete(this.studentAddress);}
}