package cleanCode.proxyExam;

import java.util.Collection;

public interface Bank {

    Collection<Account> getAccounts();
    void setAccounts(Collection<Account> accounts);
}
