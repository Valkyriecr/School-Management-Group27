
package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.domain.Country;

public class CityFactory {
    public static City build(String cityId, String cityName, Country country){
        if (cityId == null||cityId.isEmpty())
            throw new IllegalArgumentException("cityId is not Valid!");
        if (cityName == null||cityName.isEmpty())
            throw new IllegalArgumentException("City Name is not Valid!");
        if(country==null)
            throw new IllegalArgumentException("Country is not Valid!");

        return new City.Builder().cityId(cityId).cityName(cityName).country(country).build();
    }
    public static City.CityId buildId(City city){return new City.CityId(city.getCityId());}
}
