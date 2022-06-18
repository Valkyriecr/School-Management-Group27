//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.service.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.factory.EmployeeAddressFactory;
import za.ac.cput.schoolmanagement.service.service.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeAddressServiceImplementationTest {
public final EmployeeAddress employeeAddress= EmployeeAddressFactory.build("test-for-staff-Id");
public EmployeeAddress.EmployeeAddressId employeeAddressId=EmployeeAddressFactory.buildId(this.employeeAddress);
@Autowired
    public EmployeeAddressService service;
@Test
    @Order(1)
    void save(){
    EmployeeAddress isSaved=this.service.save(this.employeeAddress);
    assertAll(
            ()->assertNotNull(isSaved),()->assertEquals(this.employeeAddress,isSaved)
    );


    }
    @Test
    @Order(4)
    void tearDown(){
    this.service.delete(this.employeeAddress);
}
@Test
    @Order(2)
    void read(){
    Optional<EmployeeAddress> read=this.service.read(this.employeeAddressId);
    System.out.println(read);
    assertAll(
            ()->assertTrue(read.isPresent()),()->assertEquals(this.employeeAddress,read.get())
    );
}
@Test
@Order(5)
void findAll() {
    List<EmployeeAddress>employeeAddressList=this.service.findAll();
    assertEquals(0,employeeAddressList.size());
}
@Test
    @Order(3)
    void findByStaffId(){
    String staffId=this.employeeAddressId.getStaffId();
    List<EmployeeAddress> employeeAddressList=this.service.findByStaffId(staffId);
    System.out.println(employeeAddressList);
    assertSame(1,employeeAddressList.size());
}

}
