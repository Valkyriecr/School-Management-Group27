/*
 * Name.java
 * Mary-Beth Agulhas
 * 219082367
 * 18 June 2022
 */
package za.ac.cput.schoolmanagement.domain;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Name {
    //Variables
    @NotNull
    private final String firstName;
    @NotNull
    private final String middleName;
    @NotNull
    private final String lastName;
    //Builder constructor
    private Name(Builder builder)
    {
        this.firstName  = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName   = builder.lastName;
    }
    //Getters
    public String getFirstName() {

        return firstName;
    }

    public String getMiddleName() {

        return middleName;
    }

    public String getLastName() {

        return lastName;
    }
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
        return "Builder{" +
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
            return new Name(this);
        }//end of getName method

    }


}


