/*
 * NameRepository.java
 * Mary-Beth Agulhas
 * 219082367
 * 18 June 2022
 */
package za.ac.cput.schoolmanagement.repository;

import za.ac.cput.schoolmanagement.domain.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class NameRepository implements INameRepository{
    private final List<Name> nameList;
    private static NameRepository nameRepository;

    private NameRepository()
    {
        this.nameList = new ArrayList<>();
    }

    public static NameRepository nameRepository(){
        if (nameRepository == null) {
            nameRepository = new NameRepository();
        }
        return nameRepository;
    }
    //Save method
    public Name save(Name name)
    {
        this.nameList.add(name);
        return name;
    }
    //read method
    public Optional<Name> read(String s) {
        return Optional.empty();

    }
    public Name reader (Name name ){
        for (Name n : nameList) {
            if (Objects.equals(name.getFirstName(), n.getFirstName())
                    && Objects.equals(name.getMiddleName(), n.getMiddleName())
                    && Objects.equals(name.getLastName(), n.getFirstName()))
                return n;
        }
        return  null;
    }
    //delete method
    public void delete(Name name){
        this.nameList.remove(name);
    }

    //find all method
    public List<Name> findAll(){
        return this.nameList;
    }
}
