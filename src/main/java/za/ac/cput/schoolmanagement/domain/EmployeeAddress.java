//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(EmployeeAddress.EmployeeAddressId.class)
public class EmployeeAddress implements Serializable{
    @NotNull
    @Id
    public String staffId;
    protected EmployeeAddress(){

    }

    public EmployeeAddress(Builder builder){
        this.staffId=builder.staffId;
    }

    public String getStaffId() {

        return staffId;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "staffId='" + staffId + '\'' +
                '}';
    }

    public static class Builder
    {
        public String staffId;
        public Builder staffId(String staffId) {
            this.staffId = staffId;
            return this;
        }
            public Builder copy(EmployeeAddress employeeAddress){
            this.staffId= employeeAddress.staffId;
            return this;
            }
            public  EmployeeAddress build(){
            return new EmployeeAddress(this);}
            }
            public static class EmployeeAddressId implements Serializable
            {
                public String staffId;
                public EmployeeAddressId(String staffId){this.staffId=staffId;}
                protected EmployeeAddressId(){}
                public String getStaffId(){return staffId;}
            }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeAddress that = (EmployeeAddress) o;
        return Objects.equals(staffId, that.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);
    }
}


