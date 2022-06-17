/*
Erin Rowan
215271157
StudentFactory.java
 */
package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Student;
import za.ac.cput.schoolmanagement.util.Helper;


public class StudentFactory {
    public static Student build(String studentId, String email){
        if(studentId==null||studentId.isEmpty())
            throw new IllegalArgumentException("studentId is not valid!");
        if(email==null||email.isEmpty())
            throw new IllegalArgumentException("email is not valid!");
        return new Student.Builder().studentId(studentId).email(email).build();
    }
    public static Student.StudentId buildId(Student student){
        return new Student.StudentId(student.getStudentId());
    }
    public static Student createStudent(String studentId, String email){
        if(!Helper.isValidEmail(email)){
            System.out.println("Email is not valid!");
            return null;
        }
        if(Helper.isNullorEmpty(studentId)|| Helper.isNullorEmpty(email))
            return null;
        return null;
    }
}
