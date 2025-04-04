package BankServices;

public class Withdrawal extends Operation {
    public Withdrawal(int date, double value) {
        super(date, value);
    }

    public String toString() {
        return getDate() + "," + getValue() + "-";
    }
}
