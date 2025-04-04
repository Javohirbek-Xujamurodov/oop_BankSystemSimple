package BankServices;

import library.list.MyArrayList;
import library.list.MyList;


public class Bank {
	private String name;
	private MyList accounts = new MyArrayList();
	private int lastAccountCode = 0;

	public Bank(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public int createAccount(String ownerName, int date, double initial) {
		lastAccountCode++;
		Account acc = new Account(lastAccountCode, ownerName, date, initial);
		accounts.add(acc);
		System.out.println("Created: " + acc);
		System.out.println("Accounts size: " + accounts.size());
		return lastAccountCode;
	}
	
	public Account deleteAccount(int code, int date) throws InvalidCode {
		Account acc = getAccount(code);
		double balance = acc.getBalance();
		acc.withdraw(date , balance);
		accounts.remove(acc);
		return acc;
	}

	public Account getAccount(int code) throws InvalidCode {
		for (int i = 0; i < accounts.size(); i++) {
			Account acc = (Account) accounts.get(i);
			if (acc.getCode() == code) {
				return acc;
			}
		}
		throw new InvalidCode();
	}

	public void deposit(int code, int date, double value) throws InvalidCode {
		Account acc = getAccount(code);
		if (date < acc.getLastOperationDate()) {
			date = acc.getLastOperationDate();
		}
		acc.deposit(date, value);
	}

	public void withdraw(int code, int date, double value) throws InvalidCode {
		Account acc = getAccount(code);
		if (date < acc.getLastOperationDate()) {
			date = acc.getLastOperationDate();
		}
		if (value > acc.getBalance()) {
			throw new InvalidCode("Insufficient funds");
		}
		acc.withdraw(date, value);

	}
	
	public void transfer(int fromCode, int toCode, int date, double value) throws InvalidCode {
		Account fromAcc = getAccount(fromCode);
		Account toAcc = getAccount(toCode);

		if (date < fromAcc.getLastOperationDate()) {
			date = fromAcc.getLastOperationDate();
		}

		if ( value > fromAcc.getBalance()) {
			throw new InvalidCode("Insufficient funds for transfer");
		}
		fromAcc.withdraw(date, value);
		toAcc.withdraw(date, value);
	}
	
	public double getTotalDeposit() {
		double total = 0;
		for (int i = 0; i < accounts.size(); i++) {
			Account acc = (Account) accounts.get(i);
			total += acc.getBalance();
		}
		return total;
	}
	
	public MyList getAccounts() {
		return accounts;
	}
	

	public MyList getZeroAccounts() {
		MyList zeroAccounts = new MyArrayList();
		for (int i = 0; i < accounts.size(); i++) {
			Account acc = (Account) accounts.get(i);
			if (acc.getBalance() == 0) {
				zeroAccounts.add(acc);
			}
		}
		return zeroAccounts;
	}

	public MyList getAccountsByBalance(double low, double high) {
		MyList filteredAccounts = new MyArrayList();
		for (int i = 0; i < accounts.size(); i++) {
			Account acc = (Account) accounts.get(i);
			if (acc.getBalance() >= low && acc.getBalance() <= high) {
				filteredAccounts.add(acc);
			}
		}
		return filteredAccounts;
	}
	
	public long getNumberHigher(double min) {
		long count = 0;
		for (int i = 0; i < accounts.size(); i++) {
			Account acc = (Account) accounts.get(i);
			if (acc.getBalance() < min) {
				count++;
			}
		}
		return count;
	}
}
