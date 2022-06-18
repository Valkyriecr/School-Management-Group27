package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;

public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName, int postalCode, City city){
      if(complexName==null||complexName.isEmpty())
          throw new IllegalArgumentException("Complex name is invalid!");
      if(streetName==null||streetName.isEmpty())
          throw new IllegalArgumentException("Street Name is invalid!");
      if(unitNumber==null||unitNumber.isEmpty())
          throw new IllegalArgumentException("Unit number is invalid!");
      if(postalCode==0)
          throw new IllegalArgumentException("Postal code is invalid!");
      if(city==null)
          throw new IllegalArgumentException("City is invalid!");


          return new Address.Builder().unitNumber(unitNumber)
                  .complexName(complexName).
                  streetNumber(streetNumber)
                  .streetName(streetName)
                  .postalCode(postalCode)
                  .city(city)
                  .build();
    }

}
