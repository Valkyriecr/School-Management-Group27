
package za.ac.cput.schoolmanagement.domain;


import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class Country {
    //Variables
    @NotNull
    String countryId;
    @NotNull
    String name;
    //Constructor
    public Country(){
        countryId=null;
        name=null;
    }

    //Getters and Setters
    public String getCountryId() {return countryId;}
    public void setCountryId(String countryId) {this.countryId = countryId;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}



    //Builder Pattern
    public static class Builder{
        public String countryId;
        public String name;

        public Builder countryId(String countryId){this.countryId=countryId;return this;}
        public Builder name(String name){this.name=name;return this;}


        public Country build(){
            Country country = new Country();
            country.setCountryId(countryId);
            country.setName(name);
            return country;
        }
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId='" + countryId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int hashCode(){return Objects.hash(countryId,name);
    }

    public static class CountryId implements Serializable{
        public String countryId;
        public CountryId(String countryId){this.countryId=countryId;}
    }
}

