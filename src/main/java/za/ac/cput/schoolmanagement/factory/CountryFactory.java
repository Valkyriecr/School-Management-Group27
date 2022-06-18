/*CountryFactory.java
Factory for the CountryFactory
Author: Zaakirah Fakier (220461503)
Date: 18 June 2022
 */
package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Country;

public class CountryFactory {
    public static Country build(String countryId, String countryName)
    {
        if(countryId ==null ||countryId.isEmpty() )
            throw new IllegalArgumentException("Country Id is required!");
        if( countryName ==null||countryName.isEmpty() )
            throw new IllegalArgumentException("Name is required!");
        return new Country.Builder().countryId(countryId)
                .countryName(countryName).build();

    }
    public static Country.CountryIdentity buildId(Country country)
    {
        return new Country.CountryIdentity(country.getCountryId());
    }
}
