package cleanCode.exception;

import cleanCode.function.EmployeeRecord;

import java.util.Collections;
import java.util.List;

public class NullProcessOne {

    public static void main(String[] args) {
        List<EmployeeRecord> employeeRecords = getEmployees();
        for (EmployeeRecord employeeRecord : employeeRecords) {
            System.out.println("employeeRecord = " + employeeRecord);
        }
       // System.out.println("employeeRecords = " + employeeRecords.size());

    }

    public static List<EmployeeRecord> getEmployees() {
        return Collections.emptyList();
    }
}
