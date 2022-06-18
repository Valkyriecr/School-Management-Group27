package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Country;

public class CountryFactory {
    public static Country build(String countryId, String name){
        if (countryId == null||countryId.isEmpty())
            throw new IllegalArgumentException("countryId is not Valid!");
        if (name == null||name.isEmpty())
            throw new IllegalArgumentException("Country Name is not Valid!");

        return new Country.Builder().countryId(countryId).name(name).build();
    }
}
