package BankServices;

public abstract class Operation {
	private int date;
	private double value;

	public Operation(int date, double value) {
		this.date = date;
		this.value = value;
	}

	public int getDate() {
		return date;
	}

	public double getValue() {
		return value;
	}
}
