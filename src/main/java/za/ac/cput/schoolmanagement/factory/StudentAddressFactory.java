/*
Erin Rowan
215271157
StudentFactory.java
 */
package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.StudentAddress;

public class StudentAddressFactory {
    public static StudentAddress build(String studentId){
        if(studentId==null || studentId.isEmpty())
            throw new IllegalArgumentException("studentId is not valid!");
        return new StudentAddress.Builder().studentId(studentId).build();
    }
    public static StudentAddress.StudentAddressId buildId(StudentAddress studentAddress){
        return new StudentAddress.StudentAddressId(studentAddress.getStudentId());
    }
}
