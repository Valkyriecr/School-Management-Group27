/* CityRepository.java
   Repository for the City
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 15 June 2022
 */
package za.ac.cput.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.City;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City,City.CityId>{
    List<City> findAll();
    List<City> findById(String id);
}
