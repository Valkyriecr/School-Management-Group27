/* CityServiceImplementationTest.java
   Tests for the City Service Implementation
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 17 June 2022
 */
package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.factory.CityFactory;
import za.ac.cput.schoolmanagement.service.service.CityService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class CityServiceImplementationTest {
    private final City city = CityFactory.createCity("#City134","Liverpool");
    private City.CityId cityId = CityFactory.createCityId(this.city);

    @Autowired
    public CityService service;

    @Test
    void a_save() {
        City isCreated= this.service.save(this.city);
        assertAll(
                ()->assertNotNull(isCreated),
                ()->assertEquals(this.city,isCreated)
        );
    }

    @Test
    void b_read() {
        Optional<City> read= this.service.read(this.cityId);
        System.out.println(read);
        assertAll(
                ()-> assertTrue(read.isPresent()),
                ()-> assertEquals(this.city,read.get())
        );
    }

    @Test
    void d_delete() {
        this.service.delete(this.city);
    }

    @Test
    void e_findAll() {
        List<City> cityList = this.service.findAll();
        assertEquals(0, cityList.size());
    }

    @Test
    void c_findById() {
        String id = this.cityId.getId();
        List<City> cityList = this.service.findById(id);
        System.out.println(cityList);
        assertSame(1,cityList.size());
    }
}