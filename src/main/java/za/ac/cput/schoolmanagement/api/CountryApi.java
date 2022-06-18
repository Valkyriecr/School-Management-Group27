/*CountryApi.java
Api for the CountryApi
Author: Zaakirah Fakier (220461503)
Date: 18 June 2022
 */
package za.ac.cput.schoolmanagement.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.service.service.CountryService;
@Component
public class CountryApi {
    private final CountryService countryService;
    @Autowired
    public CountryApi(CountryService countryService){
        this.countryService=countryService;
    }
    public Country save(Country country){
        return this.countryService.save(country);
    }

}
