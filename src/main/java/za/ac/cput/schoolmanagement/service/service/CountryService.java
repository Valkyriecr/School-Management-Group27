/*CountryService.java
Service for the interface CountryServiceImplementation
Author: Zaakirah Fakier (220461503)
Date: 18 June 2022
 */
package za.ac.cput.schoolmanagement.service.service;

import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface CountryService extends IService<Country,Country.CountryIdentity> {
        List<Country> findAll();
        //void deleteById(String id);
        List<Country> findByCountryId(String countryId);
}