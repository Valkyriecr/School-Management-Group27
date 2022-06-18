//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {
@Test public void buildSuccessful(){
    Employee employee= EmployeeFactory.build("testing-id","dpengmarais99@gmail.com");
    System.out.println(employee);
    assertNotNull(employee);

}
@Test void buildFail(){
    Exception exception= assertThrows((IllegalArgumentException.class),()->EmployeeFactory.build(null,"dpengmarais99@gmail.com"));
    String exceptionMessage= exception.getMessage();
    System.out.println(exceptionMessage);
    assertSame("staffID is needed here!", exceptionMessage);
}
}