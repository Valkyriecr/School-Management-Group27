/*
 * Name.java
 * Mary-Beth Agulhas
 * 219082367
 * 18 June 2022
 */
package za.ac.cput.schoolmanagement.factory;
import za.ac.cput.schoolmanagement.domain.Name;

//add throw illegal argument exceptions
public class NameFactory {
    public static Name build(String firstName, String middleName, String lastName) {
        if (firstName == null || firstName.isEmpty())
            throw new IllegalArgumentException("First n is needed here!");
        if (middleName == null || middleName.isEmpty())
            throw new IllegalArgumentException("Middle n is needed");
        if (lastName == null || lastName.isEmpty())
            throw new IllegalArgumentException("Last n is needed");

            return new Name.Builder()
                    .firstName(firstName)
                    .middleName(middleName)
                    .lastName(lastName)
                    .build();
    }
}
