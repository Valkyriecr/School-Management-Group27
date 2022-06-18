package za.ac.cput.schoolmanagement.domain;




import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class Address {

    //Variables
    @NotNull
    String unitNumber,complexName,streetNumber,streetName;
    @NotNull
    int postalCode;
    @NotNull
    @Embedded
    City city;


    //Getters And Setters
    public String getUnitNumber() {return unitNumber;}
    public void setUnitNumber(String unitNumber) {this.unitNumber = unitNumber;}

    public String getComplexName() {return complexName;}
    public void setComplexName(String complexName) {this.complexName = complexName;}

    public String getStreetNumber() {return streetNumber;}
    public void setStreetNumber(String streetNumber) {this.streetNumber = streetNumber;}

    public String getStreetName() {return streetName;}
    public void setStreetName(String streetName) {this.streetName = streetName;}

    public int getPostalCode() {return postalCode;}
    public void setPostalCode(int postalCode) {this.postalCode = postalCode;}

    public City getCity() {return city;}
    public void setCity(City city) {this.city = city;}



    //Builder Pattern
    public static class Builder{
        private String unitNumber,complexName,streetNumber,streetName;
        private  int postalCode;
        private City city;

        public Builder unitNumber(String unitNumber){this.unitNumber=unitNumber;return this;}
        public Builder complexName(String complexName){this.complexName=complexName;return this;}
        public Builder streetNumber(String streetNumber){this.streetNumber=streetNumber;return this;}
        public Builder streetName(String streetName){this.streetName=streetName;return this;}
        public Builder postalCode(int postalCode){this.postalCode=postalCode;return this;}
        public Builder city(City city){this.city=city;return this;}

        public Address build(){
            Address address = new Address();
            address.setCity(city);
            address.setComplexName(complexName);
            address.setUnitNumber(unitNumber);
            address.setStreetName(streetName);
            address.setStreetNumber(streetNumber);
            address.setPostalCode(postalCode);
            return address;
        }

    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode +
                ", city=" + city +
                '}';
    }
}
