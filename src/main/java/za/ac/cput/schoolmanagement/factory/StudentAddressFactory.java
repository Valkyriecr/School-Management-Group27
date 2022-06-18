/*
Erin Rowan
215271157
StudentFactory.java
 */
package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

public class StudentAddressFactory {
    public static StudentAddress build(String studentId, Address studentAddress){
        if(studentId==null || studentId.isEmpty())
            throw new IllegalArgumentException("studentId is not valid!");
        if(studentAddress==null)
            throw new IllegalArgumentException("Address is not Valid!");
        return new StudentAddress.Builder().studentId(studentId).StudentAddress(studentAddress).build();
    }
    public static StudentAddress.StudentAddressId buildId(StudentAddress studentAddress){
        return new StudentAddress.StudentAddressId(studentAddress.getStudentId());
    }
}
