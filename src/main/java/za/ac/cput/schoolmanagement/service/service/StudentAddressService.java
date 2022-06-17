/*
Erin Rowan
215271157
StudentAddressService.java
 */
package za.ac.cput.schoolmanagement.service.service;

import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;

public interface StudentAddressService extends IService<StudentAddress, StudentAddress.StudentAddressId> {
    List<StudentAddress>findAll();
    List<StudentAddress>findByStudentId(String studentId);
}
