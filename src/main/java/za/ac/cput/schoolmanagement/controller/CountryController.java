/*CountryController.java
controller for the CountryController
Author: Zaakirah Fakier (220461503)
Date: 18 June 2022
 */
package za.ac.cput.schoolmanagement.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.service.service.CountryService;
import javax.validation.Valid;
import java.util.List;
import za.ac.cput.schoolmanagement.api.CountryApi;
@RestController
@RequestMapping("SchoolManagementGroup27/country/")
@Slf4j
public class CountryController {
    public final CountryService countryService;
    @Autowired public CountryController(CountryService countryService){
        this.countryService=countryService;
    }

    @PostMapping("save")
    public ResponseEntity<Country> save(@Valid @RequestBody Country country){
        log.info("save Request:{}",country);
        Country save=countryService.save(country);
        return ResponseEntity.ok(save);
   /* }

    @GetMapping("read/{countryId}")
    public ResponseEntity<Country> read(@PathVariable Country.CountryIdentity countryId)
    {
        log.info("Read Request:{}",countryId);
        Country country=this.countryService.read(countryId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);

    }
    @DeleteMapping("delete/{countryId}")
    public ResponseEntity<Void> delete(@PathVariable Country country){
        log.info("Read Request:{}",country);
        this.countryService.delete(country);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("Get All")
    public ResponseEntity<List<Country>> findAll(){
        List<Country> countryList= this.countryService.findAll();
        return ResponseEntity.ok(countryList);
   */ }
}
