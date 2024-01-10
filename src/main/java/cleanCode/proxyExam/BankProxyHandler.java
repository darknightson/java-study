package cleanCode.proxyExam;

import org.checkerframework.checker.units.qual.A;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

// 프록시 API 가 필요한 InvocationHandler
public class BankProxyHandler implements InvocationHandler {

    private Bank bank;

    public BankProxyHandler(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();

        if ( methodName.equals("getAccounts")) {
            bank.setAccounts(getAccountsFromDatabase());
            return bank.getAccounts();
        } else if ( methodName.equals("setAccounts")) {
            bank.setAccounts((Collection<Account>) args[0]);
            setAccountToDatabase(bank.getAccounts());
            return null;
        }
        else {
            System.out.println("methodName = " + methodName);
            System.out.println(" 지정된 메서드 없음. ");
        }

        return bank.getAccounts();
    }

    protected Collection<Account> getAccountsFromDatabase() {
        // 데이터 베이스로 부터 값을 가져온다.
        return List.of(new Account("anthony.son","1111-1111"), new Account("basic", "2222-2222"));
    }

    protected void setAccountToDatabase(Collection<Account> accounts) {
        bank.setAccounts(accounts);
    }
}
