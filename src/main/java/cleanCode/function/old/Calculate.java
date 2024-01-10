package cleanCode.function.old;

import cleanCode.function.EmployeeRecord;
import cleanCode.function.InvalidEmployeeType;
import cleanCode.function.Money;

public class Calculate {

    public Money calculatePay(EmployeeRecord e) throws InvalidEmployeeType {
        switch (e.getType()) {
            case COMMISSIONED:
                return calculateCommissionedPay(e);
            case HOURLY:
                return calculateHourlyPay(e);
            case SALARIED:
                return calculateSalariedPay(e);
            default:
                throw new InvalidEmployeeType(e.getType().toString());
        }
    }

    private Money calculateSalariedPay(EmployeeRecord e) {
        return null;
    }


    private Money calculateHourlyPay(EmployeeRecord e) {
        return null;
    }

    private Money calculateCommissionedPay(EmployeeRecord e) {
        return null;
    }
}
