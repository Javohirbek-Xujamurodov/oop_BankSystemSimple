package BankServices;

import library.list.MyList;

import java.util.List;


public class Account {
	private String owner;
	private double balance;
	private int lastDate;
	List<String> movements;

	public Account(int lastAccountCode, String ownerName, int date, double initial) {
	}

	public String toString() {
		return null;
	}
		
	public MyList getMovements() {
		return null;
	}
	
	public MyList getDeposits() {
		return null;
	}

	public MyList getWithdrawals() {
		return null;
	}

	public int getCode() {
		return 0;
	}

	public double getBalance() {
		return balance;
	}

	public void withdraw(int date, double balance) {
	}

	public int getLastOperationDate() {
		return lastDate;
	}

	public void deposit(int date, double value) {
	}
}
