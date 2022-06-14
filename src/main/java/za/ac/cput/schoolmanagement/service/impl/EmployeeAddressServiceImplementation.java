//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.repository.EmployeeAddressRepository;
import za.ac.cput.schoolmanagement.service.service.EmployeeAddressService;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeAddressServiceImplementation implements EmployeeAddressService {
    private final EmployeeAddressRepository  repository;

    @Autowired public EmployeeAddressServiceImplementation(EmployeeAddressRepository repository)
    {

        this.repository=repository;

    }
    @Override
    public EmployeeAddress save(EmployeeAddress employeeAddress)
    {

        return this.repository.save(employeeAddress);

    }

    @Override
    public Optional<EmployeeAddress> read(EmployeeAddress.EmployeeAddressId employeeAddressId)
    {

        return this.repository.findById(employeeAddressId);

    }

    @Override
    public void delete(EmployeeAddress employeeAddress)
    {

        this.repository.delete(employeeAddress);

    }

    @Override
    public List<EmployeeAddress> findAll()
    {

        return this.repository.findAll();

    }


    @Override
    public List findByStaffId(String id)
    {
        return this.repository.findByStaffId(id);

    }
}
