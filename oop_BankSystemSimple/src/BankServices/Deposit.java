package BankServices;

public class Deposit extends Operation {
    public Deposit(int date, double value) {
        super(date, value);
    }

    public String toString() {
        return getDate() + "," + getValue() + "+";
    }
}
