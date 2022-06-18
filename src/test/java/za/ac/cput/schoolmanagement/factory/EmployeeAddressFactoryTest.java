//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeAddressFactoryTest {
@Test public void buildSuccessful() {
    EmployeeAddress employeeAddress = EmployeeAddressFactory.build("testing-id");
    System.out.println(employeeAddress);
    assertNotNull(employeeAddress);

}
@Test void buildFail(){
    Exception exception= assertThrows(IllegalArgumentException.class,()->EmployeeAddressFactory.build(null));
    String exceptionMessage= exception.getMessage();
    System.out.println(exceptionMessage);
    assertSame("staffId is needed here!",exceptionMessage);
}
}