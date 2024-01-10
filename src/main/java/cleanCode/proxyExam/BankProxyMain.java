package cleanCode.proxyExam;

import java.lang.reflect.Proxy;
import java.util.Collection;

public class BankProxyMain {
    public static void main(String[] args) {
        Bank bank = (Bank) Proxy.newProxyInstance(Bank.class.getClassLoader(), new Class[]{Bank.class},new BankProxyHandler(new BankImpl()));

        Collection<Account> accounts = bank.getAccounts();
        for (Account account : accounts) {
            System.out.println("account = " + account.getName());
            System.out.println("account = " + account.getAccountNumber());
        }
    }
}
