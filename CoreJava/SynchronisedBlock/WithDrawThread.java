package com.wipro.assign;

public class WithDrawThread extends Thread{
	private BankAccount account;
	private double amount;
	public WithDrawThread(BankAccount account, double amount) {
		
		this.account = account;
		this.amount = amount;
	}
	
	public void run() {
		account.withdraw(amount);
	}
	
	

}
