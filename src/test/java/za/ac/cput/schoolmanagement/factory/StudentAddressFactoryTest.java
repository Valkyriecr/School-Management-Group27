/*
Erin Rowan
215271157
StudentAddressFactoryTest.java
 */
package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;


class StudentAddressFactoryTest {
    public final Country country = CountryFactory.build("ZA","South Africa");
    public final City city = CityFactory.build("CPT","Cape Town",country);
    public final Address address = AddressFactory.build("19","house","19","Yellowwood",7800,city);
    @Test
    public void buildSuccessful(){

        StudentAddress studentAddress=StudentAddressFactory.build("1234",address);
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }
    @Test
    void buildFailure(){
        Exception e=assertThrows(IllegalArgumentException.class,()->StudentAddressFactory.build(null,address));
        String exceptionMessage= e.getMessage();
        System.out.println(exceptionMessage);
        assertSame("studentId is not valid!",exceptionMessage);
    }
}