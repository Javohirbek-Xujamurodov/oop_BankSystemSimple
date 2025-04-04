package BankServices;

import library.list.MyArrayList;
import library.list.MyList;

public class Account {
	private int code;
	private String owner;
	private double balance;
	private int lastDate;
	private MyList movements = new MyArrayList();

	public Account(int code, String ownerName, int date, double initial) {
		this.code = code;
		this.owner = ownerName;
		this.lastDate = date;
		this.balance = 0;
		deposit(date, initial);
	}

	public String toString() {
		return code + "," + owner + "," + lastDate + "," + balance;
	}

	public MyList getMovements() {
		return movements;
	}

	public MyList getDeposits() {
		MyList deposits = new MyArrayList();
		for (int i = 0; i < movements.size(); i++) {
			Object o = movements.get(i);
			if (o instanceof Deposit) {
				deposits.add(o);
			}
		}
		return deposits;
	}

	public MyList getWithdrawals() {
		MyList withdrawals = new MyArrayList();
		for (int i = 0; i < movements.size(); i++) {
			Object o = movements.get(i);
			if (o instanceof Withdrawal) {
				withdrawals.add(o);
			}
		}
		return withdrawals;
	}

	public int getCode() {
		return code;
	}

	public double getBalance() {
		return balance;
	}

	public int getLastOperationDate() {
		return lastDate;
	}

	public void deposit(int date, double value) {
		lastDate = date;
		balance += value;
		movements.add(new Deposit(date, value));
	}

	public void withdraw(int date, double value) {
		lastDate = date;
		balance -= value;
		movements.add(new Withdrawal(date, value));
	}
}
