/* CityServiceImplementation.java
   Implementation for the City Service
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 16 June 2022
 */
package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.repository.CityRepository;
import za.ac.cput.schoolmanagement.service.service.CityService;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImplementation implements CityService {
    private final CityRepository repo;

    @Autowired
    public CityServiceImplementation(CityRepository repo){
        this.repo = repo;
    }

    @Override
    public City save(City city){
        return this.repo.save(city);
    }

    @Override
    public Optional<City> read(City.CityId cityId){
        return this.repo.findById(cityId);
    }

    @Override
    public void delete(City city){
        this.repo.delete(city);
    }

    @Override
    public List<City> findAll(){
        return this.repo.findAll();
    }

    @Override
    public List findById(String id){
        return this.repo.findById(id);
    }


}
