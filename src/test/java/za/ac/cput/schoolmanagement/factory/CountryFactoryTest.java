/*CountryTest.java
Test for the CountryFactoryTest
Author: Zaakirah Fakier (220461503)
Date: 18 June 2022
 */

package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.schoolmanagement.domain.Country;


class CountryFactoryTest {
    @Test public void buildSuccessful(){
        Country country= CountryFactory.build("FR","France");
        System.out.println(country);
        assertNotNull(country);

    }
    @Test void buildFail(){
        Exception exception= assertThrows((IllegalArgumentException.class),()->CountryFactory.build(null,"France"));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("countryID is needed here!", exceptionMessage);
    }
}