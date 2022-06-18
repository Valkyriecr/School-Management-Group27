/*
 * NameServiceImplementation.java
 * Mary-Beth Agulhas
 * 219082367
 * 18 June 2022
 */
package za.ac.cput.schoolmanagement.service.impl;

import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.repository.NameRepository;
import za.ac.cput.schoolmanagement.service.service.NameService;

import java.util.List;
import java.util.Optional;

public class NameServiceImplementation  implements NameService{
private final NameRepository repository;
    private static NameServiceImplementation nameService;

    private NameServiceImplementation(){

        this.repository = NameRepository.nameRepository();
    }

    public static NameServiceImplementation getNameService(){
        if(nameService ==null)
            nameService = new NameServiceImplementation();
        return  nameService;
    }
    @Override
    public Name save(Name name) {
        return this.repository.save(name);
    }

    @Override
    public Optional<Name> read(String s) {
        return Optional.empty();
    }
    public Name reader(Name name) {
        return this.repository.reader(name);
    }

    @Override
    public void delete(Name name) {
      this.repository.delete(name);
    }
    public List<Name> findAll() {
        return this.repository.findAll();
    }

}




