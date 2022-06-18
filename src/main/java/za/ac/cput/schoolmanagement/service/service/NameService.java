/*
 * NameService.java
 * Mary-Beth Agulhas
 * 219082367
 * 18 June 2022
 */
package za.ac.cput.schoolmanagement.service.service;


import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface NameService extends IService<Name, String > {
    List<Name> findAll();

}

