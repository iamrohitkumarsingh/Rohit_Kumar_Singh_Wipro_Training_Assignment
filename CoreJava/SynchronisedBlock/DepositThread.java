package com.wipro.assign;

public class DepositThread extends Thread{
	
	private BankAccount account;
	private  double  amount;
	public DepositThread(BankAccount account, double amount) {
		super();
		this.account = account;
		this.amount = amount;
	}
	
	public void run() {
		account.deposit(amount);
	}

}
