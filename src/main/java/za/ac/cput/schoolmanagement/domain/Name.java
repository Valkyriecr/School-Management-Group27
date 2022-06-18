/*
 * Name.java
 * Mary-Beth Agulhas
 * 219082367
 * 18 June 2022
 */
package za.ac.cput.schoolmanagement.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.util.Objects;
@Embeddable
public class Name {
    //Variables
    @NotNull
    private String firstName;
    @NotNull
    private String middleName;
    @NotNull
    private String lastName;

   //Constructor
    public Name(){
        firstName=null;
        middleName=null;
        lastName=null;
    }
    //Getters
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName){this.firstName=firstName;}

    public String getMiddleName() {return middleName;}
    public void setMiddleName(String middleName) {this.middleName = middleName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    //Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return firstName.equals(name.firstName) && middleName.equals(name.middleName) && lastName.equals(name.lastName) ;
    }

    //Hashcode
    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


    //Builder Pattern
    public static class Builder{
        private String firstName;
        private String middleName;
        private String lastName;

        public Builder firstName(String firstName)
        {
            this.firstName=firstName;
            return this;
        }
        public Builder middleName(String middleName)
        {
            this.middleName=middleName;
            return this;
        }
        public Builder lastName(String lastName)
        {
            this.lastName=lastName;
            return this;
        }


        public Name build(){
            Name name = new Name();
            name.setFirstName(firstName);
            name.setLastName(lastName);
            name.setMiddleName(middleName);
            return name;
        }//end of getName method

    }


}