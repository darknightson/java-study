package cleanCode.function.refactor;

import cleanCode.function.EmployeeRecord;
import cleanCode.function.InvalidEmployeeType;

public class EmployeeFactoryImpl implements EmployeeFactory {

    @Override
    public Employee makeEmployee(EmployeeRecord r) throws InvalidEmployeeType {

        switch (r.getType()) {
            case COMMISSIONED:
                return new CommissionedEmployee(r);
            case HOURLY:
                return new HourlyEmployee(r);
            case SALARIED:
                return new SalariedEmployee(r);
            default:
                throw new InvalidEmployeeType(r.getType());
        }
    }
}
