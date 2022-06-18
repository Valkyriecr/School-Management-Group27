/*
 * NameFactoryTest.java
 * Mary-Beth Agulhas
 * 219082367
 * 18 June 2022
 */
package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;

import za.ac.cput.schoolmanagement.domain.Name;

import static org.junit.jupiter.api.Assertions.*;

class NameFactoryTest {

    //no issues
    @Test
    public void madeSuccessfully(){
        Name name= NameFactory.build("Amy","Liz", "Low");
        System.out.println(name);
        assertNotNull(name);
    }

    //with issues
    @Test

    public void firstNameError() {

        Exception exception;
        exception = assertThrows(IllegalArgumentException.class, () ->
                NameFactory.build(null, "Liz", "Louw"));
        String exceptionMessage = exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("First n is needed here!", exceptionMessage);

    }

}

