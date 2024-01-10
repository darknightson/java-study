package cleanCode.function.refactor;

import cleanCode.function.EmployeeRecord;
import cleanCode.function.InvalidEmployeeType;

public interface EmployeeFactory {

    public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType;
}
