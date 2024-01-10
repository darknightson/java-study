package cleanCode.proxyExam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// 추상화를 위한 POJO (Plain Old Java Object) 구현
public class BankImpl implements Bank {

    private List<Account> accounts;
    @Override
    public Collection<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void setAccounts(Collection<Account> accounts) {
        this.accounts = new ArrayList<>(accounts);
        for (Account account : accounts) {
            this.accounts.add(account);
        }
    }
}
