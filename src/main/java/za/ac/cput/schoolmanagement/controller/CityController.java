/* CityController.java
   Controller for the City entity
   Author: Juan-Lee Zidane Klink (218236883)
   Date: 17 June 2022
 */
package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.service.service.CityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("SchoolManagementGroup27/city/")
@Slf4j
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @PostMapping("save")
    public ResponseEntity<City> save(@Valid @RequestBody City city){
        log.info("save request:{}",city);
        City save = cityService.save(city);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("delete/{cityId}")
    public ResponseEntity<Void> delete(@PathVariable City city){
        log.info("Read Request:{}",city);
        this.cityService.delete(city);
        return ResponseEntity.noContent().build();
    }

}
