/*
Erin Rowan
215271157
StudentAddressFactoryTest.java
 */
package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

import static org.junit.jupiter.api.Assertions.*;


class StudentAddressFactoryTest {
    @Test
    public void buildSuccessful(){
        StudentAddress studentAddress=StudentAddressFactory.build("1234");
        System.out.println(studentAddress);
        assertNotNull(studentAddress);
    }
    @Test
    void buildFailure(){
        Exception e=assertThrows(IllegalArgumentException.class,()->StudentAddressFactory.build(null));
        String exceptionMessage= e.getMessage();
        System.out.println(exceptionMessage);
        assertSame("studentId is not valid!",exceptionMessage);
    }
}