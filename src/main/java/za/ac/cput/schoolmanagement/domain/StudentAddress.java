/*
Erin Rowan
215271157
StudentAddress.java
 */
package za.ac.cput.schoolmanagement.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(StudentAddress.StudentAddressId.class)
public class StudentAddress implements Serializable {
    //Variables
    @NotNull
    @Id
    public String studentId;
    @NotNull
    @Embedded
    public Address address;

    //Constructor
    protected StudentAddress(){
        studentId=null;
        address=null;
    }
    //Getters AND Setters
    public String getStudentId(){
        return studentId;
    }
    public void setStudentId(String studentId) {this.studentId = studentId;}

    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }

    //Builder Method
    public static class Builder {
        public String studentId;
        public Address address;


        public Builder studentId(String studentId) {this.studentId = studentId;return this;}
        public Builder StudentAddress(Address address) {this.address=address;return this;}

        public StudentAddress build(){
            StudentAddress studentAddress= new StudentAddress();
            studentAddress.setStudentId(studentId);
            studentAddress.setAddress(address);
            return studentAddress;
        }
    }

        public static class StudentAddressId implements Serializable{
            public String studentId;
            public StudentAddressId (String studentId){this.studentId=studentId;}
            protected StudentAddressId(){}
            public String getStudentId(){return studentId;}
        }
        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if(o==null || getClass() !=o.getClass()) return false;
            StudentAddress studentAddress = (StudentAddress) o;
            return Objects.equals(studentId, studentAddress.studentId);
        }

    @Override
    public int hashCode(){return Objects.hash(studentId);}


}
