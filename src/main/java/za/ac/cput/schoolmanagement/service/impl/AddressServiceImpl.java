package za.ac.cput.schoolmanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.repository.AddressRepository;
import za.ac.cput.schoolmanagement.service.service.AddressService;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService {
    public final AddressRepository repository;
    @Autowired
    public AddressServiceImpl(AddressRepository repository)
    {
        this.repository=repository;
    }
    @Override
    public Address save(Address address){return this.repository.save(address);}

    @Override
    public Optional<Address> read(Address.AddressId addressId)
    {
        return this.repository.findById(addressId);
    }
    @Override
    public void delete(Address address){this.repository.delete(address);}
    @Override
    public List<Address> findAll(){return this.repository.findAll();}

    @Override
    public List findByUnitNumber(String unitNumber){return this.repository.findByUnitNumber(unitNumber);}
}
