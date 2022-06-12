package za.ac.cput.schoolmanagement.service.service;

import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;
import java.util.Optional;

public interface EmployeeAddressService extends IService <EmployeeAddress,String> {
  List<EmployeeAddress> findAll();
  void deleteById(String id);
  List<EmployeeAddress>findByStaffId(String staffId);
}
