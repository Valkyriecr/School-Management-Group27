//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.factory;


import za.ac.cput.schoolmanagement.domain.EmployeeAddress;

public class EmployeeAddressFactory {
public static EmployeeAddress build(String staffId){
    if (staffId== null || staffId.isEmpty())
        throw new IllegalArgumentException("staffId is needed here!");
    return new EmployeeAddress.Builder().staffId(staffId).build();
}
public static EmployeeAddress.EmployeeAddressId buildId(EmployeeAddress employeeAddress){
    return new EmployeeAddress.EmployeeAddressId(employeeAddress.getStaffId());
}
}
