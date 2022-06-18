/*
Erin Rowan
215271157
StudentAddress.java
 */
package za.ac.cput.schoolmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(StudentAddress.StudentAddressId.class)
public class StudentAddress implements Serializable {
    @NotNull
    @Id
    public String studentId;
    protected StudentAddress(){

    }
    public StudentAddress(Builder builder){this.studentId=builder.studentId;}

    public String getStudentId(){
        return studentId;
    }

    public static class Builder {
        public String studentId;
        public Builder studentId(String studentId) {
            this.studentId = studentId;
            return this;
        }
        public StudentAddress build() {
            return new StudentAddress(this);
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

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                '}';
    }
}
