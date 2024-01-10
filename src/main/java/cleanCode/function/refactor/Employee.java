package cleanCode.function.refactor;

import cleanCode.function.Money;

public abstract class Employee {

    public abstract boolean isPayday();
    public abstract Money calculatePay();
    public abstract void deliverPay(Money pay);
}
