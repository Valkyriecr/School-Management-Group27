/*CountryServiceImplementation.java
Service implementation for the CountryServiceImplementation
Author: Zaakirah Fakier (220461503)
Date: 18 June 2022
 */
package za.ac.cput.schoolmanagement.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.repository.CountryRepository;

import za.ac.cput.schoolmanagement.service.service.CountryService;


import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImplementation implements CountryService {
    public final CountryRepository repository;

    @Autowired
    public CountryServiceImplementation(CountryRepository repository)
    {
        this.repository=repository;
    }
    @Override
    public Country save(Country country)
    {
        return this.repository.save(country);
    }
    @Override
    public Optional<Country> read(Country.CountryIdentity countryIdentity){return this.repository.findById(countryIdentity);}

    @Override
    public void delete(Country country){this.repository.delete(country);}
    @Override
    public List<Country> findAll(){return this.repository.findAll();}

    /*
    @Override
    public void deleteById(String id)
    {
        Optional<Country>country=read(id);
        if(country.isPresent())delete(country.get());
    }
     */

    @Override
    public List findByCountryId(String countryId)
    {
        return this.repository.findByCountryId(countryId);
    }
}
