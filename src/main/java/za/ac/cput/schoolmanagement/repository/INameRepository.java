/*
 * INameRepository.java
 * Mary-Beth Agulhas
 * 219082367
 * 18 June 2022
 */
package za.ac.cput.schoolmanagement.repository;

import za.ac.cput.schoolmanagement.domain.Name;

import java.util.List;


public interface INameRepository extends IRepository<Name, String>{
   List<Name> findAll();
}
