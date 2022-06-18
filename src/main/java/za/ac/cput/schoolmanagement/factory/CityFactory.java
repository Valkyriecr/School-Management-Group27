/* CityFactory.java
   Factory for the City
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 14 June 2022
 */
package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.util.Helper;


public class CityFactory {
    public static City createCity(String id, String name){
        Helper.checkStringParam("id", id);
        Helper.checkStringParam("name", name);


        return new City.Builder().setId(id)
                .setName(name)
                .build();
    }

    public static City.CityId createCityId(City city){
        return new City.CityId(city.getId());
    }
}
