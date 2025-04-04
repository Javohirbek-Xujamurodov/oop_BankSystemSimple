package BankServices;

public class InvalidCode extends Throwable {
    public InvalidCode() {
        super("Invalid Code is invalid");
    }

    public InvalidCode(String message) {
        super(message);
    }
}
