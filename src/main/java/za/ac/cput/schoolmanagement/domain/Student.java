/*
Erin Rowan
215271157
Student.java
 */
package za.ac.cput.schoolmanagement.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(Student.StudentId.class)
public class Student {
    @NotNull
    @Id
    public String studentId;
    @NotNull
    public String email;

    protected Student(){}
    public Student(Builder builder){
        this.studentId=builder.studentId;
        this.email=builder.email;
    }
    public String getStudentId() {return studentId;}
    public String getEmail() {return email;}

    public static class Builder{
        public String studentId;
        public String email;

        public Builder studentId(String studentId){
            this.studentId=studentId;
            return this;
        }
        public Builder email(String email){
            this.email=email;
            return this;
        }
        public Builder copy(Student student){
            this.studentId=student.studentId;
            this.email=student.email;
            return this;
        }
        public Student build(){ return new Student(this);}}

    public static class StudentId implements Serializable{
        public String studentId;
        public StudentId(String studentId){this.studentId=studentId;}

        protected StudentId(){}
        public String getStudentId(){return studentId;}
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null|| getClass()!=o.getClass()) return false;
        Student student=(Student) o;
        return studentId.equals(student.studentId);
    }
    @Override
    public int hashCode(){return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
