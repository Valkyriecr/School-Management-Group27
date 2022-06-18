package za.ac.cput.schoolmanagement.factory;
//Mohammed Raaziq Parker 219154554
import org.junit.jupiter.api.Test;
import za.ac.cput.schoolmanagement.domain.EmployeeAddress;
import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {
    @Test
    public void buildSuccessful() {
        Address Address = AddressFactory.build("asd","asd","asd","sd","asd");
        System.out.println(Address);
        assertNotNull(Address);

    }
    @Test void buildFail(){
        Exception exception= assertThrows(IllegalArgumentException.class,()->AddressFactory.build(null,null,null,null,null));
        String exceptionMessage= exception.getMessage();
        System.out.println(exceptionMessage);
        assertSame("Id is needed here!",exceptionMessage);


    }
}