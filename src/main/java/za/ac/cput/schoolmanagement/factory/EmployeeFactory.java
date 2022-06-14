//Daniel Marais
//Student Number: 219476845
//Group 27
package za.ac.cput.schoolmanagement.factory;

import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.schoolmanagement.domain.Employee;
import za.ac.cput.schoolmanagement.util.Helper;

public class EmployeeFactory {
    public static Employee build(String staffId, String email){
        if (staffId==null|| staffId.isEmpty())
            throw new IllegalArgumentException("staffId is needed here!");
        if (email== null|| email.isEmpty())
            throw new IllegalArgumentException("email is needed here!");
        return new Employee.Builder().staffId(staffId).email(email).build();
    }

    public static Employee.EmployeeId buildId(Employee employee) {
        return new Employee.EmployeeId(employee.getStaffid());
    }
        public static Employee createEmployee(String email, String staffId) {
            if (!Helper.isValidEmail(email)) {
                System.out.println("Email is not valid");
                return null;
            }
            if (Helper.isNullorEmpty(staffId) || Helper.isNullorEmpty(email))
                return null;
                return null;
            }

        }
