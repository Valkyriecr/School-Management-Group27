package za.ac.cput.schoolmanagement.factory;
//Mohammed Raaziq Parker 219154554
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.util.Helper;

public class AddressFactory {

    public static Address build(String unitNumber, String complexName, String streetNumber, String streetName, String postalCode)
    {
        Helper.checkStringParam("unitNumber", unitNumber);
        Helper.checkStringParam("complexName", complexName);
        Helper.checkStringParam("streetName", streetName);
        Helper.checkStringParam("streetNumber", streetNumber);
        Helper.checkStringParam("postalCode", postalCode);
        return new Address.Builder().unitNumber(unitNumber).complexName(complexName).streetNumber(streetNumber).streetName(streetName).postalCode(postalCode).build();
    }
    public static Address.AddressId buildId(Address address)
    {
        return new Address.AddressId(address.getUnitNumber());
    }


}
