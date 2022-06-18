package za.ac.cput.schoolmanagement.repository;
//Mohammed Raaziq Parker 219154554
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.repository.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Address.AddressId> {
    List<Address> findAll();
    List<Address>findByUnitNumber(String unitNumber);
}

