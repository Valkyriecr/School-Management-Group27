/*
Erin Rowan
215271157
StudentFactoryTest.java
 */
package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Student;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {
    @Test
    public void buildSuccessful(){
        Student student=StudentFactory.build("Erin","erowan95@gmail.com");
        System.out.println(student);
        assertNotNull(student);
    }
    @Test
    void buildFailure(){
        Exception e=assertThrows(IllegalArgumentException.class,()->StudentFactory.build(null,"erowan95@gmail.com"));
        String exceptionMessage= e.getMessage();
        System.out.println(exceptionMessage);
        assertSame("studentId is not valid!",exceptionMessage);
    }

}