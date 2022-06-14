//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.service.service;

import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;


public interface EmployeeAddressService extends IService <EmployeeAddress,EmployeeAddress.EmployeeAddressId> {
  List<EmployeeAddress> findAll();

  List<EmployeeAddress>findByStaffId(String staffId);
}
