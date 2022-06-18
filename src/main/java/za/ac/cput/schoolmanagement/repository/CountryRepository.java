/*CountryRepository.java
Repository for the interface CountryRepository
Author: Zaakirah Fakier (220461503)
Date: 18 June 2022
 */
package za.ac.cput.schoolmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Country;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country,Country.CountryIdentity> {
    List<Country> findAll();
    List<Country> findByCountryId(String countryId);
}
