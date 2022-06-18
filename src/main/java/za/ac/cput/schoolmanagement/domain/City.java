/* City.java
   Entity for the City
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 14 June 2022
 */
package za.ac.cput.schoolmanagement.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Embeddable
@IdClass(City.CityId.class)
public class City implements Serializable {
    @NotNull
    @Id
    private String id;
    @NotNull
    private String name;
    /* uncomment after merge
    @Embedded
    private Country country;

    private Country getCountry(){
        return country;
    }
     */

    protected City(){

    }


    private City(Builder builder){
        this.id = builder.id;
        this.name = builder.name;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


    public static class Builder {
        private String id;
        private String name;

        public Builder setId(String id){
            this.id = id;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }


        public Builder copy(City city){
            this.id = city.id;
            this.name = city.name;
            return this;
        }

        public City build(){
            return new City(this);
        }
    }

    public static class CityId implements Serializable{
        private String id;

        public CityId(String id){
            this.id = id;}
            protected CityId(){
    }
    public String getId(){
            return id;
    }}

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        City city = (City) o;
        return id.equals(city.id);

    }

    @Override
    public int hashCode(){return Objects.hash(id);}
}
