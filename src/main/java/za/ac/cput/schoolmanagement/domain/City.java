
package za.ac.cput.schoolmanagement.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class City {
    @NotNull
    String cityId;
    @NotNull
    String cityName;
    @NotNull
    @Embedded
    Country country;
    //constructor
    public City(){
        cityId=null;
        cityName=null;
        country=null;
    }
    //Getters And Setters
    public String getCityId() {return cityId;}

    public void setCityId(String cityId) {this.cityId = cityId;}

    public String getCityName() {return cityName;}

    public void setCityName(String cityName) {this.cityName = cityName;}

    public Country getCountry() {return country;}

    public void setCountry(Country country) {this.country = country;}



    //Builder Pattern

    public static class Builder{
        public String cityId;
        public String cityName;
        public Country country;
        public Builder cityId(String cityId){this.cityId=cityId;return this;}
        public Builder cityName(String cityName){this.cityName=cityName;return this;}
        public Builder country(Country country){this.country=country;return this;}

        public City build(){
            City city = new City();
            city.setCityId(cityId);
            city.setCityName(cityName);
            city.setCountry(country);
            return city;
        }
    }

    public static class CityId implements Serializable{
        public String cityId;
        public CityId(String cityId){this.cityId=cityId;}
        public String getCityId(){return cityId;}
    }
    @Override
    public boolean equals(Object o){
        if(this==o)return true;
        if(o==null || getClass()!=o.getClass())return false;
        City city = (City) o;
        return cityId.equals(city.cityId)&&cityName.equals(city.cityName)&&country.equals(city.country);
    }
    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName, country);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", country=" + country +
                '}';
    }
}
