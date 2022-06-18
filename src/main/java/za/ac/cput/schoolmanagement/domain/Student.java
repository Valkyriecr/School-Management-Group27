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
@Table(name = "Students")
@IdClass(Student.StudentId.class)
public class Student {
    //Variables
    @NotNull
    @Id
    @Column(name = "Student_Id")
    public String studentId;
    @NotNull
    @Column(name="Email")
    public String email;
    @NotNull
    @Embedded
    @Column(name="Student_Name")
    public Name name;

    //Constructor
    public Student(){
        studentId=null;
        email=null;
        name=null;
    }

    //Getters/Setters
    public String getStudentId() {return studentId;}
    public void setStudentId(String studentId) {this.studentId = studentId;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public Name getName(){return name;}
    public void setName(Name name) {this.name = name;}


    //Builder Pattern
    public static class Builder{
        public String studentId;
        public String email;
        public Name name;

        public Builder studentId(String studentId){this.studentId=studentId;return this;}
        public Builder email(String email){this.email=email; return this;}
        public Builder name(Name name){this.name = name; return this;}

        public Student build(){
           Student student =new Student();
           student.setStudentId(studentId);
           student.setEmail(email);
           student.setName(name);
           return student;
        }

        public Builder copy(Student student){
            this.studentId=student.studentId;
            this.email=student.email;
            this.name=student.name;
            return this;
        }
    }

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
                ", name=" + name +
                '}';
    }

}
