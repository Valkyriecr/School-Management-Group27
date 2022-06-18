/* CityFactoryTest.java
   Test class for the CityFactory
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 14 June 2022
 */
package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.City;


import static org.junit.jupiter.api.Assertions.*;

class CityFactoryTest {
    @Test
    public void testCreateCity(){
        City city = CityFactory.createCity("#City123", "New York");
        System.out.println(city.toString());
        assertNotNull(city);
    }

    @Test
    public void testFailedCreateCity(){
        Exception exception = assertThrows((IllegalArgumentException.class),()-> CityFactory.createCity(null,"London"));
        String errorMessage = exception.getMessage();
        System.out.println(errorMessage);
        assertSame("City Id is required!", errorMessage);
    }



}