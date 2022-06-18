/* CityService.java
   Service for the City
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 16 June 2022
 */
package za.ac.cput.schoolmanagement.service.service;

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface CityService extends IService<City,City.CityId> {
    List<City> findAll();
    List<City> findById(String id);
}
