package cleanCode.function.refactor;

import cleanCode.function.EmployeeRecord;
import cleanCode.function.InvalidEmployeeType;
import cleanCode.function.Money;

public class HourlyEmployee extends Employee {


    public HourlyEmployee(EmployeeRecord employeeRecord) {

    }

    @Override
    public boolean isPayday() {
        return false;
    }

    @Override
    public Money calculatePay() {
        return null;
    }

    @Override
    public void deliverPay(Money pay) {

    }
}
