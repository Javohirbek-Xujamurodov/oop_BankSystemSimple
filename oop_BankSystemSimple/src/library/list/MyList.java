package library.list;

import BankServices.Account;

public interface MyList {
    Object add(Object element);
    Object get(int index);
    int capacity();
    int size();

    void remove(Account acc);
}
