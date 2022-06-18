package za.ac.cput.schoolmanagement.service.service;
//Mohammed Raaziq Parker 219154554
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.service.IService;

import java.util.List;


    public interface AddressService extends IService<Address,Address.AddressId>
    {
        List<Address> findAll();
        List<Address>findByUnitNumber(String unitNumber);
    }

